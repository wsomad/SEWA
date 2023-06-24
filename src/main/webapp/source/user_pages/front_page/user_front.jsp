<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="user_front.css">
    <link rel="icon" type="images/png" href="https://drive.google.com/uc?export=view&id=1WnCOPug2C25vqv-_nxG6QvVp2VSMVnp1">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <title>SEWA | Car Rental Malaysia</title>
</head>
<body>
    <header class="header">
        <nav class="nav">
            <img src="\src\main\webapp\source\images\header.png" href="admin-front.html" class="nav_logo" alt="">
            <ul class="nav_items">
                <li class="nav_item">
                    <a href="\source\header_pages\about_page\about-sewa.html" class="nav_link">About</a>
                    <a href="#" class="nav_link">Service</a>
                    <a href="#" class="nav_link">Help</a>
                </li>
            </ul>
            <button class="button" id="form-open">Sign up</button>
        </nav>
    </header>

    <section class="home">
        <div class="front_container">
            <div class="front_text">
                <p>Explore Your<br>
                    Destination With Us<br>
                </p>
            </div>
            <div class="form_container">
                <div class="login_form">
                	<form method="post" action="login">
                        <h2>Sign in</h2>
                        <div class="input_form">
                            <input name="email" type="email" placeholder="Enter your email" required>
                            <i class="fa fa-envelope email"></i>
                        </div>
                        <div class="input_form">
                            <input name="password" type="password" placeholder="Enter your password" required>
                            <i class="fa fa-lock password"></i>
                            <i class="fa fa-eye-slash pw_hide"></i>
                        </div>

                        <div class="option_field">
                            <a href="#" class="forgot_pw">Forgot password?</a>
                        </div>

                        <button class="button">Sign in</button>
                    </form>
                </div>
            </div>
        </div>
    </section>

    <section class="home2">
        <div class="form_container2">
            <i class="fa fa-times form_close"></i>
            <div class="signup_form">
            	<form method="post" action="registration">
                    <h2>Sign up</h2>
                    <div class="name_container">
	                    <div class="input_form">
	                        <input type="text" name="firstname" placeholder="First Name" required>
	                        <i class="fa fa-user email"></i>
	                    </div>
	                    <div class="input_form">
	                        <input type="text" name="lastname" placeholder="Last Name" required>
	                        <i class="fa fa-user email"></i>
	                    </div>
	                </div>
	                <div class="email_phone">
	                    <div class="input_form">
	                        <input type="email" name="email" placeholder="Email" required>
	                        <i class="fa fa-envelope email"></i>
	                    </div>
	                    <div class="input_form">
	                        <input type="tel" name="phonenum" placeholder="Mobile Number" required>
	                        <i class="fa fa-phone phone"></i>
	                    </div>
	                </div>
                    <div class="input_form">
                        <input type="text" name="username" placeholder="Create Username" required>
                        <i class="fa fa-user username"></i>
                    </div>
                    <div class="username_password">
	                    <div class="input_form">
	                        <input type="password" placeholder="Create Password" required>
	                        <i class="fa fa-lock password"></i>
	                        <i class="fa fa-eye-slash pw_hide"></i>
	                    </div>
	                    <div class="input_form">
	                        <input type="password" name="password" placeholder="Confirm Password" required>
	                        <i class="fa fa-lock password"></i>
	                        <i class="fa fa-eye-slash pw_hide"></i>
	                    </div>
	                </div>
                </form>
            </div>
        </div>
    </section>
    <script src="user_front.js"></script>

    <footer class="footer">
        <div class="foot_container">
            <div class="top">
                <div class="logo_details">
                    <img src="https://drive.google.com/uc?export=view&id=1rWwPwfCQUj6RBPxEIzCbLcgGwGl0xU59" alt="">
                </div>
                <div class="company_register">
                    <p>Owned by SEWA MALAYSIA SDN. BHD.</p>
                </div>
                <div class="media_details">
                    <a href="#"><i class="fab fa-facebook"></i></a>
                    <a href="#"><i class="fab fa-instagram"></i></a>
                    <a href="#"><i class="fab fa-telegram"></i></a>
                    <a href="#"><i class="fab fa-twitter"></i></a>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>