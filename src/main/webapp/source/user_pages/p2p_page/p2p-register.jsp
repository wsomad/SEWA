<!DOCTYPE html>
<html lang="en">
<style>
	<%@include file="p2p-register.css"%>
</style>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="p2p-register.css">
    <link rel="icon" type="images/png" href="https://drive.google.com/uc?export=view&id=1WnCOPug2C25vqv-_nxG6QvVp2VSMVnp1">
    <link href="https://fonts.googleapis.com/css2?family=Montserrat&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <title>SEWA | Car Rental Malaysia</title>
</head>
<body>
    <header class="header">
        <nav class="nav">
            <img src="https://drive.google.com/uc?export=view&id=1hnKz5R1P7uMvl4c2qAnSFUHrdH4Sy41B" href="admin-front.html" class="nav_logo" alt="">
            <button class="button" id="form-open">Back</button>
        </nav>
    </header>
    <section class="register_form">
        <div class="peer_title">
            <p>Become Our Peer Now!</p>
        </div>
        <div class="peer_word">
            <p> By becoming one of our peer, you can earn some income when customer booked your car! </p>
        </div>
        <div class="form_container">
            <div class="form_title">
                <p>Rent as Peer</p>
            </div>
            <form method="post" action="p2p-registerController">
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Brand <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Brand" name="brand" required>
                        </div>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Model <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Model" name="model" required>
                        </div>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Type <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Type" name="type" required>
                        </div>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Year Manufactured  <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Year Manufactured" name="yearManufactured" required>
                        </div>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Type of Gas <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Type of Gas" name="gasType" required>
                        </div>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Number of Seater  <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="No. of Seater" name="numberOfSeater" required>
                        </div>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Transmission<span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <select name="transmission" id="transmission" required>
                                <option value="none" selected disabled hidden>Transmission Type</option>
                                <option value="1">Automatic</option>
                                <option value="2">Manual</option>
                            </select>
                        </div>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Registration Number <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Registration Number" name="registrationNumber" required>
                        </div>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Roadtax Expiry Date <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Roadtax Expiry Date" name="roadtaxExpiryDate" required>
                        </div>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Engine Number <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Engine Number" name="engineNumber" required>
                        </div>
                    </div>
                    
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Chasis Number <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Chasis Number" name="chasisNumber" required>
                        </div>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Insurance Type<span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <select name="insuranceType" id="insuranceType" required>
                                <option value="none" selected disabled hidden>Insurance Type</option>
                                <option value="1">1st Party</option>
                                <option value="2">3rd Party</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Insurance Name <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Insurance Name" name="insuranceName" required>
                        </div>
                    </div>
                    <div class="form_box">
                        <span class="form_indicator"><h4>Insurance Expiry Date <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Insurance Expiry Date" name="insuranceExpiryDate" required>
                        </div>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Choose Location <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <select name="location" id="location" required>
                                <option value="none" selected disabled hidden>Location</option>
                                <option value="1">Johor</option>
                                <option value="2">Klang Valley</option>
                                <option value="3">Melaka</option>
                                <option value="4">Perak</option>
                                <option value="5">Pulau Pinang</option>
                                <option value="6">Terengganu</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Set Rental Charge <span class="form_mark">*</span></h4></span>
                        <div class="input_form">
                            <input type="text" placeholder="Set Rental Charge RM/hour" name="rentalCharge" required>
                        </div>
                    </div>
                </div>
                <div class="form_row">
                    <div class="form_box">
                        <span class="form_indicator"><h4>Upload Vehicle Image <span class="form_mark">*</span></h4></span>
                        <div class="upload_container">
                            <input class="file_upload" type="file" id="file" accept="image/*" required>
                        </div>
                    </div>
                </div>
                <div class="register_button">
                    <button class="submit_button">Register</button>
                    <button class="cancel_button">Cancel</button>
                </div>
            </form>
        </div>

        <div class="information_message">
            <div class="reminder_word">
                <p><i class="fa fa-lightbulb"></i> Friendly Reminder</p>
            </div>
            <div class="reminder_sentence">
                <h4>Your registration might fail if road tax and insurance of your car is expired.</h4>
            </div>
        </div>
    </section>
    <section class="nothing">
        
    </section>
</body>
</html>