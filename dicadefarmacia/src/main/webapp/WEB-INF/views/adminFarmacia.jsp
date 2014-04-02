<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<jsp:include page="includes/header.jsp" />
</head>

<body>

    <!-- Fixed navbar -->
    <jsp:include page="includes/navbarsemlogin.jsp" />

    <div class="container">
        <div class="row">
            <div class="col-md-3">
                <h3>Área do administrador</h3>
                <ul id="menu" class="nav nav-pills nav-stacked">
                    <li id="menuRemedio"><a id="linkRemedio">Remédio</a></li>
                </ul>
            </div>
            <div class="col-md-9" id="content">
                
            </div>
        </div>
    </div>

    <jsp:include page="includes/footer.jsp" />
    
    <script type="text/javascript">
    	$("#linkRemedio").click(function(){
            $("#content").load("remedio");
            $("#menuRemedio").addClass("active");
        });
    </script>

</body>
</html>
