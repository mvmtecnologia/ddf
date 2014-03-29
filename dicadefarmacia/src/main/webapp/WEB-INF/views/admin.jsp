<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<jsp:include page="./includes/header.jsp" />
</head>

<body>

    <!-- Fixed navbar -->
    <jsp:include page="./includes/navbarsemlogin.jsp" />

    <div class="container">
        <div class="row">
            <div class=".col-md-1">
                <h3>Área do administrador</h3>
                <button class="btn btn-primary btn-lg">Usuário</button>
                <button class="btn btn-primary btn-lg">Farmácia</button>
            </div>
        </div>
    </div>

    <jsp:include page="./includes/footer.jsp" />

</body>
</html>
