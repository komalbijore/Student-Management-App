<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Bootstrap demo</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">
		<h1>Email Page</h1>
		<form action="send" method="post">

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">To
					Email</label> <input type="email" name="to" class="form-control"
					id="exampleFormControlInput1" placeholder="name@example.com">
			</div>

			<div class="mb-3">
				<label for="exampleFormControlInput1" class="form-label">Subject</label>
				<input type="text" name="subject" class="form-control"
					id="exampleFormControlInput1" placeholder="enter subject">
			</div>

			<div class="mb-3">
				<label for="exampleFormControlTextarea1" class="form-label">Body</label>
				<textarea class="form-control" name="body"
					id="exampleFormControlTextarea1" rows="3"></textarea>
			</div>
			<button type="submit" class="btn btn-primary">Send</button>
			<br> <a href="home">Home Page</a>
		</form>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
		crossorigin="anonymous"></script>
</body>
</html>