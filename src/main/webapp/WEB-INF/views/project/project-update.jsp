<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="Util.UrlConst"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Update</title>
</head>
<body>
	<!-- Breadcrumb -->
	<div class="container page__heading-container">
	    <div class="page__heading">
	        <div class="d-flex align-items-center">
	            <div>
	                <nav aria-label="breadcrumb">
	                    <ol class="breadcrumb mb-0">
	                        <li class="breadcrumb-item"><a href="<c:url value="<%=UrlConst.HOME %>" />">Home</a></li>
	                        <li class="breadcrumb-item"><a href="<c:url value="<%=UrlConst.PROJECT_DASHBOARD %>" />">Project</a></li>
	                        <li class="breadcrumb-item active" aria-current="page">
	                            Project Update
	                        </li>
	                    </ol>
	                </nav>
	                <h1 class="m-0">Update New Project</h1>
	            </div>
	        </div>
	    </div>
	</div>
	<!-- End Breadcrumb -->
	<div class="container page__container">
		<div class="card card-form">
            <div class="row no-gutters">
                <div class="col-lg-4 card-body">
                    <p><strong class="headings-color">Rules</strong></p>
                    <p class="text-muted">There is no rule!</p>
                </div>
                <div class="col-lg-8 card-form__body card-body">
                 	<form action="<c:url value="<%=UrlConst.PROJECT_UPDATE %>" />" method="post">
						<div class="form-group">
							<label for="id">Id:</label> <input type="text"
								class="form-control" name="id" id="id">
						</div>
						<div class="form-group">
                            <label for="name">Name:</label>
                            <input type="text" class="form-control" name="name" id="name">
                        </div>
                        <div class="form-group">
                            <label for="description">Description:</label>
                            <input type="text" class="form-control" name="description" id="description">
                        </div>
                        <div class="form-group">
                            <label for="start_date">Start Date:</label>
                            <input type="date" class="form-control" name="start_date" id="start_date">
                        </div>
						<div class="form-group">
                            <label for="end_date">End Date:</label>
                            <input type="date" class="form-control" name="end_date" id="end_date">
                        </div>
						<div class="form-group">
							<label for="owner">Owner:</label>
							<textarea type="text" class="form-control" name="owner"
								id="owner" aria-label="With textarea"></textarea>
						</div>
                        <button class="btn btn-primary w-25 justify-content-center" type="submit" class="btn btn-primary">Update</button>
                    </form>
                </div>
            </div>
        </div>
     </div>
</body>
</html>