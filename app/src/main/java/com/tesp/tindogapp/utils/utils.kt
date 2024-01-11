package com.tesp.tindogapp.utils

fun isEmailValid(email: String): Boolean {
    val emailRegex = Regex("^[A-Za-z](.*)([@]{1})(.{1,})(\\.)(.{1,})")
    return emailRegex.matches(email)
}

fun isUsernameValid(username: String, minLength: Int = 6, maxLength: Int = 20): Boolean {
    return username.isNotEmpty() && username.length in minLength..maxLength
}
fun isPasswordValid(password: String): Boolean {
    // At least 8 characters, including uppercase, lowercase, digit, and special character
    val passwordRegex =
        Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@\$!%*?&.,])[A-Za-z\\d@$!%*?&.,]{8,}\$")
    return passwordRegex.matches(password)
}

fun isCodeValid(pincode: String): Boolean {
    return pincode.isNotEmpty() //&& code.length in minLength..maxLength
}
//, minLength: String = 4, maxLength: Int = 4
fun checkData( email: String, password: String, confirmPassword: String): Boolean {
    return(
        //isUsernameValid(username) &&
        isEmailValid(email) &&
        isPasswordValid(password) &&
        isPasswordValid(confirmPassword) &&
        password == confirmPassword
    )

}



//

/*
fun IsValidCredentials(): Boolean {
    val emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\$"
    var emailValid = this.Email.matches(emailRegex.toRegex())
    var passwordValid = this.Password.length>5;

    return passwordValid && emailValid;
}


fun DoSignUp(mainViewModel: MainViewModel, navController: NavController) {
    navController.navigate("signPage")
}

 */