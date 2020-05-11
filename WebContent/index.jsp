<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <link type="text/css" rel="stylesheet" href="css/style.css">
    <script type="text/javascript" src="js/view.js"></script>
    <script type="text/javascript" src="js/addFlavor.js"></script>
    <script type="text/javascript" src="js/removeFlavor.js"></script>
    <script type="text/javascript" src="js/singIn.js"></script>
    <script type="text/javascript" src="js/singUp.js"></script>
    <title>Neon Mixer</title>
</head>
<body>
    <div class="header">
        <div class="cl-header">
        <nav>
            <div class="nav-left">
                <a href="/">neon mixer</a>
            </div>
            <div class="nav-right">
            	<c:if test="${sessionScope.sessionLogin == null}">
                	<a onclick="singInShow()">Sing in</a>
                	<a onclick="singUpShow()">Sing up</a>
            	</c:if>
            	<c:if test="${sessionScope.sessionLogin != null}">
                	<a>${sessionScope.sessionLogin}</a>
                	<a href="/logOut">Log out</a>
            	</c:if>
            </div>
        </nav>
        <dialog id="singIn" <c:if test="${wrongLoginOrPassword == true}">open</c:if>>
        <h1>Sing in</h1>
        <form action="singIn" id="singInForm" method="post">
        	<input type="text" name="login" placeholder="Login">
        	<input type="password" name="password" placeholder="Password">
        </form>
        <button type="submit" form="singInForm">Login</button>
        <button type="button" onclick="singInClose()">Close</button>
        <c:if test="${wrongLoginOrPassword == true}"><p style="color: red;">Wrong login or <br> password!</p></c:if>
        </dialog>
        <dialog id="singUp" <c:if test="${(passwordMismatch == true) or (userExist == true) or (successfulRegistration == true) or (passwordLength == true) or (loginLength == true)}">open</c:if>>
        <h1>Sing up</h1>
        <form action="/singUp" id="singUpForm" method="post">
        	<input type="text" name="login" placeholder="Login">
        	<input type="password" name="password" placeholder="Password">
        	<input type="password" name="passwordRepeat" placeholder="Repeat password">
        </form>
        <button type="submit" form="singUpForm">Sing up</button>
        <button type="button" onclick="singUpClose()">Close</button>
        <c:if test="${passwordMismatch == true}"><p style="color: red;">Passwords mismatch!</p></c:if>
        <c:if test="${userExist == true}"><p style="color: red;">A user with this login <br> already exists!</p></c:if>
        <c:if test="${successfulRegistration == true}"><p style="color: Lime;">You have successfully <br> registered!</p></c:if>
        <c:if test="${passwordLength == true}"><p style="color: red;">Password must be <br> at least 6 characters!</p></c:if>
        <c:if test="${loginLength == true}"><p style="color: red;">Login must be <br> at least 4 characters!</p></c:if>
        </dialog>
    </div>
    </div>
    <div class="main-form">
        <div class="column-form">
        <center><p>User mixes</p></center>
		<c:forEach var="userMixes" items="${userMixes}">
            <a class="orange" href="/show?curMixId=${userMixes.mixId}">${userMixes.name}</a>
        </c:forEach>
		</div>
        <div class="column-form" style="align-items: center;">
            <form action="calculate" method="get" id="calculate">
            <input type="hidden" name="mixId" value="${selectedMixId}">
            <p style="margin-top: 0px;">PG/VG</p>
            <input type="range" name="pgvg" id="pgvg" value="${selectedMixPGVG}" step="5" onchange="pgvgchange()">
            <p id="pgvgval" style="font-size: 24pt; margin: 0px ;">PG <c:if test="${selectedMixPGVG == null}">50</c:if><c:if test="${selectedMixPGVG != null}">${selectedMixPGVG}</c:if>/<c:if test="${selectedMixPGVG == null}">50</c:if><c:if test="${selectedMixPGVG != null}">${100-selectedMixPGVG}</c:if> VG</p>
            <div class="row-form-main">
                <div class="row-form">
                    <p>Vol. of fluid(ml)</p>
                    <div class="row-form-main">
                        <span>
                            <button type="button" onclick="removevolofflud()">-</button>
                        </span>
                        <input type="text" min="0" max="100" name="volofliq" id="volofliq" value="<c:if test="${selectedMixVolOfFlud == null}">30</c:if><c:if test="${selectedMixVolOfFlud != null}">${selectedMixVolOfFlud}</c:if>">
                        <span>
                            <button type="button" onclick="addvolofflud()">+</button>
                        </span>
                    </div>
                </div>
                <div class="row-form">
                    <p>Watter(%)</p>
                    <div class="row-form-main">
                        <span>
                            <button type="button" onclick="removewater()">-</button>
                        </span>
                        <input type="text" min="0" max="100" name="water" id="water" value="<c:if test="${selectedMixWatter == null}">0</c:if><c:if test="${selectedMixWatter != null}">${selectedMixWatter}</c:if>">
                        <span>
                            <button type="button" onclick="addwater()">+</button>
                        </span>
                    </div>
                </div>
            </div>
            <p style="font-size: 18pt;">Strength of the nicotine base (mg/ml)</p>
            <div class="row-form full-width">
                <input type="range" name="strength" id="strenght" value="<c:if test="${selectedMixStrengthOfNicoBase == null}">100</c:if><c:if test="${selectedMixStrengthOfNicoBase != null}">${selectedMixStrengthOfNicoBase}</c:if>" step="1" onchange="strenghtchange()">
                <p id="strenghtval" style="font-size: 24pt; margin: 0px;"><c:if test="${selectedMixStrengthOfNicoBase == null}">100</c:if><c:if test="${selectedMixStrengthOfNicoBase != null}">${selectedMixStrengthOfNicoBase}</c:if></p>
                <p>Nicotine Content (mg/ml)</p>
                <div class="row-form-main">
                    <span>
                        <button type="button" onclick="removenico()">-</button>
                    </span>
                    <input type="text" min="0" max="100" name="nico" id="nico" value="<c:if test="${selectedMixNicoContent == null}">3</c:if><c:if test="${selectedMixNicoContent != null}">${selectedMixNicoContent}</c:if>">
                    <span>
                        <button type="button" onclick="addnico()">+</button>
                    </span>
                </div>
                <p>The content of flavorings (%)</p>
            </div>
            <div class="row-form full-width" id="flavorContainer">
            <c:if test="${flavorArr == null}">
            	<div class="row-form-main" id="flavorElement">
                    <input type="text" name="flavorName" id="flavorName" style="margin-right: 35px;" value="Flavor 1">
                    <input type="number" min="0" max="100" name="flavor" id="flavor" value="0" style="width: 10%;">
                </div>
            </c:if>
            <c:forEach var="flavorArr" items="${flavorArr}">
                <div class="row-form-main" id="flavorElement">
                    <input type="text" name="flavorName" id="flavorName" style="margin-right: 35px;" value="${flavorArr.flavorName}">
                    <input type="number" min="0" max="100" name="flavor" id="flavor" value="${flavorArr.flavorContent}" style="width: 10%;">
                </div>
            </c:forEach>
            </div>
            </form>
				<div class="row-form-main" id="addRemBut">
                    <button type="button" class="add-button" onclick="addFlavor()">Add flavor</button>
                    <button type="button" class="rem-button" onclick="removeFlavor()">Remove flavor</button>
                </div>
				<div class="col-form" style="margin-top: 10px;" id="addRemBut">
                    <button type="submit" class="add-button" form="calculate">Calculate</button>
                </div>

            </div>
        <div class="column-form" style="align-items: center;">
        <p style="box-shadow: none; font-size: 28pt; margin-top: 55px;">Your recipe</p>
        <div class="col-content-top">
            <table style="color: white;">
                <tbody>
                    <tr>
                        <td>#</td>
                        <td>ml</td>
                        <td>%</td>
                    </tr>
                    <tr>
                        <td>PG</td>
                        <td>${PGN} ml</td>
                        <td>${PGP} %</td>
                    </tr>
                    <tr>
                        <td>VG</td>
                        <td>${VGN} ml</td>
                        <td>${VGP} %</td>
                    </tr>
                    <tr>
                        <td>Nicotine base</td>
                        <td>${nicoContentN} ml</td>
                        <td>${nicoContentP} %</td>
                    </tr>
                    <tr>
                        <td>Water</td>
                        <td>${waterN} ml</td>
                        <td>${waterP} %</td>
                    </tr>
                    <c:forEach var="flavorsList" items="${flavorsList}">
                    <tr>
                        <td>${flavorsList.flavorName}</td>
                        <td>${flavorsList.flavorContentResNum} ml</td>
                        <td>${flavorsList.flavorContentResPer} %</td>
                    </tr>
                    </c:forEach>
                    <tr>
                        <td>Together</td>
                        <td>${total} ml</td>
                        <td>100 %</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <c:if test="${sessionScope.sessionLogin != null}">
        <div class="col-content-bot">
       	<input type="text" name="presetName" form="calculate" placeholder="Preset name">
        <div class="row-form-main">
        <button class="add-button" form="calculate" formaction="createPreset" formmethod="post">Save preset</button>
        <button class="rem-button" form="calculate" formaction="deletePreset" formmethod="post">Delete preset</button>
        </div>
         <c:if test="${successfulCreatedPreset == true}"><p style="color: lime;">Successful created preset!</p></c:if>
         <c:if test="${successfulDeletedPreset == true}"><p style="color: lime;">Successful deleted preset!</p></c:if>
         <c:if test="${emptyPresetName == true}"><p style="color: red;">Preset name is empty!</p></c:if>
         <c:if test="${nothingToDelete == true}"><p style="color: red;">Nothing to delete!</p></c:if>
        </div>
        </c:if>
        </div>
    </div>
</body>
</html>