app.controller('AfterLoginController', function($scope) {
 //
});

app.controller('AfterHomeController', function($scope) {
    //
});

app.controller('AfterPageController', function($scope) {
 //
});

app.controller('CheckSenhaValida', function($scope) {
    $scope.passwordRequirementsVisible = false;
    $scope.isLengthValid = false;
    $scope.isAlphaNumericValid = false;
    $scope.isUpperCaseValid = false;
    $scope.isSpecialCharValid = false;

    $scope.checkPasswordRequirements = function() {
        const password = $scope.password || ($scope.signupPassword && $scope.signupPassword.value);

        if (password) {
            $scope.isLengthValid = password.length >= 8;
            $scope.isAlphaNumericValid = /[a-zA-Z]/.test(password) && /\d/.test(password);
            $scope.isUpperCaseValid = /[A-Z]/.test(password);
            $scope.isSpecialCharValid = /[\W_]/.test(password);
        } else {
            // Handle the case when password is undefined or empty
            $scope.isLengthValid = false;
            $scope.isAlphaNumericValid = false;
            $scope.isUpperCaseValid = false;
            $scope.isSpecialCharValid = false;
        }
    };

    $scope.showPasswordRequirements = function() {
        $scope.passwordRequirementsVisible = true;
    };

    $scope.hidePasswordRequirements = function() {
        $scope.passwordRequirementsVisible = false;
    };
});