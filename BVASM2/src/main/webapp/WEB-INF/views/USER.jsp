<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Management</title>
    <style>
        table, th, td {
            border: 1px solid black;
            border-collapse: collapse;
            padding: 8px;
        }
    </style>
</head>
<body>
    <h2>User Management - CRUD</h2>
    <h5>Fill in the data below</h5>

    <!-- Form for creating or updating a user -->
    <form:form method="post" action="/users/save" modelAttribute="user">
        <table>
            <tr>
                <td>Id:</td>
                <td><form:input path="id" readonly="${not empty user.id}"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:input path="password" /></td>
            </tr>
            <tr>
                <td>Fullname:</td>
                <td><form:input path="fullname" /></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" /></td>
            </tr>
            <tr>
                <td>Admin:</td>
                <td><form:checkbox path="admin" /></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" class="btn btn-primary" value="Create"/>
                    <input type="submit" class="btn btn-primary" value="Update"/>
                    <a href="/users/reset" class="btn btn-secondary">Reset</a>
                </td>
            </tr>
        </table>
    </form:form>

    <hr>

    <!-- Form for searching user by ID -->
    <form action="/users/search" method="get" class="form-inline mb-3">
        <div class="form-group mr-2">
            <label for="userId" class="sr-only">User ID:</label>
            <input type="text" id="userId" name="id" class="form-control" placeholder="Enter User ID">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>

    <!-- Table to display user list -->
    <table>
        <thead>
            <tr>
                <th>Id</th>
                <th>Password</th>
                <th>Fullname</th>
                <th>Email</th>
                <th>Admin</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="user" items="${userList}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.password}</td>
                    <td>${user.fullname}</td>
                    <td>${user.email}</td>
                    <td>${user.admin}</td>
                    <td>
                        <a href="/users/edit/${user.id}">Edit</a>
                        <a href="/users/delete/${user.id}" onclick="return confirm('Are you sure you want to delete this user?')">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>
