<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Sidebar Layout</title>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css" rel="stylesheet">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            height: 100vh;
        }
        .sidebar {
            width: 250px;
            height: 100%;
            position: fixed;
            left: 0;
            top: 0;
            background-color: #f8f9fa;
            padding-top: 20px;
            overflow-y: auto;
        }
        .content {
            margin-left: 250px;
            padding: 20px;
            flex: 1;
        }
        .navbar-brand h3 {
            margin: 0;
            font-size: 1.5rem;
        }
    </style>
</head>
<body>
    <div class="sidebar pe-4 pb-3">
        <nav class="navbar bg-light navbar-light">
            <a href="DashboardServlet" class="navbar-brand mx-4 mb-3">
                <h3 class="text-primary"><i class="fa fa-hashtag me-2"></i>DASHMIN</h3>
            </a>
            <div class="d-flex align-items-center ms-4 mb-4">
                <div class="position-relative">
                    <img class="rounded-circle" src="./assets/admin/img/user.jpg" alt="" style="width: 40px; height: 40px;">
                    <div class="bg-success rounded-circle border border-2 border-white position-absolute end-0 bottom-0 p-1"></div>
                </div>
                <div class="ms-3">
                    <h6 class="mb-0">Jhon Doe</h6>
                    <span>Admin</span>
                </div>
            </div>
            <div class="navbar-nav w-100">
                <a href="DashboardServlet" class="nav-item nav-link active"><i class="fa fa-tachometer-alt me-2"></i>Dashboard</a>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-laptop me-2"></i>Users</a>
                    <div class="dropdown-menu bg-transparent border-0">
                        <a href="IndexUserServlet" class="dropdown-item">All</a>
                        <a href="CreateUserServlet" class="dropdown-item">Add</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-th me-2"></i>Categories</a>
                    <div class="dropdown-menu bg-transparent border-0">
                        <a href="IndexCategoryServlet" class="dropdown-item">All</a>
                        <a href="CreateCategoryServlet" class="dropdown-item">Add</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-table me-2"></i>Products</a>
                    <div class="dropdown-menu bg-transparent border-0">
                        <a href="IndexProductServlet" class="dropdown-item">All</a>
                        <a href="CreateProductServlet" class="dropdown-item">Add</a>
                    </div>
                </div>
                <div class="nav-item dropdown">
                    <a href="#" class="nav-link dropdown-toggle" data-toggle="dropdown"><i class="fa fa-chart-bar me-2"></i>Orders</a>
                    <div class="dropdown-menu bg-transparent border-0">
                        <a href="IndexOrderServlet" class="dropdown-item">All</a>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</html>
