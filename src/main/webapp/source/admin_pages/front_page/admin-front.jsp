<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="admin-front.css">
    <link rel="icon" type="images/png" href="https://drive.google.com/uc?export=view&id=1WnCOPug2C25vqv-_nxG6QvVp2VSMVnp1">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <title>SEWA | Administration</title>
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
        <div class="form_container">
            <div class="login_form">
                <form method="post" action="AdminLoginController">
                    <h2>Sign in as Admin</h2>
                    <div class="input_form">
                        <input type="email" placeholder="Enter your email" name="email" required>
                        <i class="fa fa-envelope email"></i>
                    </div>
                    <div class="input_form">
                        <input type="password" placeholder="Enter your password" name="password" required>
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
    </section>

    <section class="home2">
        <div class="form_container2">
            <i class="fa fa-times form_close"></i>
            <div class="signup_form">
                <form action="#">
                    <h2>Sign up as Admin</h2>
                    <div class="input1_form">
                        <input type="email" placeholder="Email" required>
                        <i class="fa fa-envelope email"></i>
                    </div>
                    <div class="input1_form">
                        <input type="tel" placeholder="Phone number" required>
                        <i class="fa fa-phone phone"></i>
                    </div>
                    <div class="input1_form">
                        <input type="text" placeholder="Create username" required>
                        <i class="fa fa-user username"></i>
                    </div>
                    <div class="input1_form">
                        <input type="password" placeholder="Create password" required>
                        <i class="fa fa-lock password"></i>
                        <i class="fa fa-eye-slash pw_hide"></i>
                    </div>
                    <div class="input1_form">
                        <input type="password" placeholder="Confirm your password" required>
                        <i class="fa fa-lock password"></i>
                        <i class="fa fa-eye-slash pw_hide"></i>
                    </div>

                    <button class="button">Sign up</button>

                    <div class="signin_label">
                        Already have an account?
                        <a href="#" id="login">Sign in</a>
                    </div>
                </form>
            </div>
        </div>
    </section>
    <script src="admin-front.js"></script>

    <footer class="footer">
        <div class="foot_container">
            <div class="top">
                <div class="logo_details">
                    <img src="/source/images/footer.png" alt="">
                </div>
                <div class="company_register">
                    <p>Owned by SEWA MALAYSIA SDN. BHD.</p>
                </div>
                <div class="developer_contact">
                    <p><i class="fa fa-phone phone"></i>Developer (013-XXXXXXX)</p>
                </div>
            </div>
        </div>
    </footer>
</body>
</html>