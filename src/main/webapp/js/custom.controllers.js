app.controller('AfterLoginController', function($scope) {
 //
});

app.controller('AfterHomeController', function($scope) {
    //
});

app.controller('AfterPageController', function($scope) {
 //
});

// app.controller('CheckSenhaValida', function($scope) {
//     $scope.passwordRequirementsVisible = false;
//     $scope.isLengthValid = false;
//     $scope.isAlphaNumericValid = false;
//     $scope.isUpperCaseValid = false;
//     $scope.isSpecialCharValid = false;

//     $scope.checkPasswordRequirements = function() {
//         const password = $scope.password || ($scope.signupPassword && $scope.signupPassword.value);

//         if (password) {
//             $scope.isLengthValid = password.length >= 8;
//             $scope.isAlphaNumericValid = /[a-zA-Z]/.test(password) && /\d/.test(password);
//             $scope.isUpperCaseValid = /[A-Z]/.test(password);
//             $scope.isSpecialCharValid = /[\W_]/.test(password);
//         } else {
//             // Handle the case when password is undefined or empty
//             $scope.isLengthValid = false;
//             $scope.isAlphaNumericValid = false;
//             $scope.isUpperCaseValid = false;
//             $scope.isSpecialCharValid = false;
//         }
//     };

//     $scope.showPasswordRequirements = function() {
//         $scope.passwordRequirementsVisible = true;
//     };

//     $scope.hidePasswordRequirements = function() {
//         $scope.passwordRequirementsVisible = false;
//     };
// });

function showPasswordRequirements(password) {
    document.getElementById("passwordRequirements").classList.remove('hidden');
    checkPasswordRequirements(password);
}

function hidePasswordRequirements() {
    document.getElementById("passwordRequirements").classList.add('hidden');
}

function checkPasswordRequirements(password) {
    const lengthIcon = document.getElementById("lengthIcon");
    const alphaNumericIcon = document.getElementById("alphaNumericIcon");
    const upperCaseIcon = document.getElementById("upperCaseIcon");
    const specialCharIcon = document.getElementById("specialCharIcon");

    lengthIconValid = password.length >= 8;
    alphaNumericIconValid = /[a-zA-Z]/.test(password) && /\d/.test(password);
    upperCaseIconValid = /[A-Z]/.test(password);
    specialCharIconValid = /[\W_]/.test(password);

    if (lengthIconValid &&
        alphaNumericIconValid &&
        upperCaseIconValid &&
        specialCharIconValid) {
            document.getElementById("passwordRequirements").classList.add('hidden');
        } else {
            document.getElementById("passwordRequirements").classList.remove('hidden');
        }

    lengthIcon.className = lengthIconValid ? "icon-ok" : "icon-x";
    alphaNumericIcon.className = alphaNumericIconValid ? "icon-ok" : "icon-x";
    upperCaseIcon.className = upperCaseIconValid ? "icon-ok" : "icon-x";
    specialCharIcon.className = specialCharIconValid ? "icon-ok" : "icon-x";
}