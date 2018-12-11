<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
      <meta charset="utf-8">
	  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	  <meta http-equiv="x-ua-compatible" content="ie=edge">
	  <title>Material Design Bootstrap</title>
	  <!-- Font Awesome -->
	  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
	  <!-- Bootstrap core CSS -->
	  <link href="/resources/css/bootstrap.min.css" rel="stylesheet">
	  <!-- Material Design Bootstrap -->
	  <link href="/resources/css/mdb.min.css" rel="stylesheet">
	  <!-- Your custom styles (optional) -->
	  <link href="/resources/css/style.css" rel="stylesheet">
</head>

<body>
	<header>
		<nav class="navbar fixed-top sticky-top navbar-expand-lg navbar-dark scrolling-navbar">
			<a class="navbar-brand" href="/"><img src="/resources/img/logo.png" class="img-fluid flex-center logo-img"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active"><a class="nav-link" href="#">Home
							<span class="sr-only">(current)</span>
					</a></li>
					<li class="nav-item"><a class="nav-link" href="/chart">Chart</a></li>
					<li class="nav-item"><a class="nav-link" href="/new">New</a></li>
					<li class="nav-item"><a class="nav-link" href="/collection">Collection</a></li>
					<li class="nav-item"><a class="nav-link" href="/profile">Profile</a></li>
					</li>
				</ul>
				<form class="form-inline my-2 my-lg-0 ml-auto" method="post" action="/search">
					<input class="form-control" type="search" placeholder="Search"
						aria-label="Search" name="keyword">
					<button class="btn btn-outline-white btn-md my-3 my-sm-0 ml-2"
						type="submit"><i class="fa fa-search white-text" aria-hidden="true"></i></button>
				</form>
			</div>
		</nav>
	</header>
