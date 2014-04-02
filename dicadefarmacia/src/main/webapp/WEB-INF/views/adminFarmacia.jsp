<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="includes/header.jsp" />
</head>

<body>

    <!-- Fixed navbar -->
    <jsp:include page="includes/navbarsemlogin.jsp" />

    <div class="container">
        <div class="row">
            <div class=".col-md-1">
                <h3>Área do administrador</h3>
                <ul class="nav nav-pills nav-stacked">
                    <li><a href="">Home</a></li>
                    <li><a href="remedio">Remédio</a></li>
                </ul>
            </div>
        </div>
    </div>

    <jsp:include page="includes/footer.jsp" />

</body>
</html>
