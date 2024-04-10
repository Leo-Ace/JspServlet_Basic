<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">
<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<div>
		<h1 class="w-100 text-white text-center bg-info">Product</h1>
		<div class="container">
			<form action="product?action=onadd" method="post"
				class="p-3 col-8 mx-auto shadow">
				<h4 class="text-center">Form add product</h4>
				<div class="form-group">
					<label for="productId-inp"><b>ProductId</b></label> <input
						type="text" name="productId" id="productId-inp"
						class="form-control rounded-0">
				</div>
				<div class="form-group">
					<label for="productName-inp"><b>ProductName</b></label> <input
						type="text" name="productName" id="productName-inp"
						class="form-control rounded-0">
				</div>
				<div class="form-group">
					<label for="price-inp"><b>Price</b></label> <input type="number"
						name="price" id="price-inp" class="form-control rounded-0">
				</div>
				<div class="form-group">
					<label for="quantity-inp"><b>Quantity</b></label> <input
						type="number" name="quantity" id="quantity-inp"
						class="form-control rounded-0">
				</div>
				<div class="form-group">
					<label for="description-inp"><b>Description</b></label>
					<textarea name="description" id="description-inp"
						class="form-control rounded-0" cols="30" rows="10"></textarea>
				</div>
				<div class="form-group">
					<label for="" class="d-block"><b>Status</b></label> <input
						type="radio" name="Status" id="show-inp" value="true" checked>
					<label for="show-inp" class="mx-2 d-inline">Show</label> <input
						type="radio" name="Status" id="hide-inp" value="false"> <label
						for="hide-inp" class="mx-2 d-inline">Hide</label>
				</div>
				<button type="submit" class="btn btn-info rounded-0">Submit</button>
			</form>
		</div>
	</div>

	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>
</html>