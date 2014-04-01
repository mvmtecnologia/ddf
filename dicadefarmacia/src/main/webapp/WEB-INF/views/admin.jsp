<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="./includes/header.jsp" />
</head>

<body>

    <!-- Fixed navbar -->
    <jsp:include page="./includes/navbarsemlogin.jsp" />

    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h3>Área do administrador</h3>
                <ul id="menu" class="nav nav-pills nav-stacked">
                    <li id="menuUsuario"><a id="linkUsuario">Usuário</a></li>
                    <li id="menuFarmacia"><a id="linkFarmacia">Farmácia</a></li>
                </ul>
            </div>
            <div class="col-md-9" id="content">
                
            </div>
        </div>
    </div>

    <jsp:include page="./includes/footer.jsp" />
    
    <script type="text/javascript">
    	$("#linkUsuario").click(function(){
            $("#content").load("./usuario");
            $("#menuFarmacia").removeClass("active");
            $("#menuUsuario").addClass("active");
        });
        $("#linkFarmacia").click(function(){
            $("#content").load("./farmacia");
            $("#menuUsuario").removeClass("active");
            $("#menuFarmacia").addClass("active");
        });
    </script>

</body>
</html>
