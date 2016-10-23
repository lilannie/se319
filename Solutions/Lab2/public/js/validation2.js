$(document).ready(function () {
    $("#success").hide();
    $("#failure").hide();
});

function checkForm() {
    if ($("#complete").html() == 'Finished') {
        window.location = "./googleMap.html";
    }
    var emailFlag = false, phoneNumberFlag = false, addressFlag = false;
    if (isValidEmail(document.forms['contact']['email'].value)) {
        $("#emailCheck").removeClass('fa-check-square-o');
        $("#emailCheck").addClass('fa-check-square');
        emailFlag = true;
    }
    if (isValidPhoneNumber(document.forms['contact']['phoneNumber'].value)) {
        $("#phoneNumberCheck").removeClass('fa-check-square-o');
        $("#phoneNumberCheck").addClass('fa-check-square');
        phoneNumberFlag = true;
    }
    if (isValidAddress(document.forms['contact']['address'].value)) {
        $("#addressCheck").removeClass('fa-check-square-o');
        $("#addressCheck").addClass('fa-check-square');
        addressFlag = true;
        localStorage.setItem("address", document.forms['contact']['address'].value);
    }
    if (emailFlag && phoneNumberFlag && addressFlag) {
        $("#success").slideDown();
        $('#email').prop('disabled', true);
        $('#phoneNumber').prop('disabled', true);
        $('#address').prop('disabled', true);
        $("#complete").html('Finished');
    }
}
