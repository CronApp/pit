window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.UserControl = window.blockly.js.blockly.UserControl || {};

/**
 * @function resetPassword
 *
 * Descreva esta função...
 *
 * @param email
 *
 * @author Wesley Miranda De Oliveira
 * @since 08/08/2023, 09:32:51
 *
 */
window.blockly.js.blockly.UserControl.resetPasswordArgs = [{ description: 'email', id: '7afdf898' }];
window.blockly.js.blockly.UserControl.resetPassword = async function(email) {
 var signupUsername, signupEmail, signupPassword, signupConfirmPassword;
  //
  this.cronapi.authentication.resetPassword(email);
}

/**
 * @function signUp
 *
 * Signup
 *
 * @param signupUsername
 * @param signupEmail
 * @param signupPassword
 * @param signupConfirmPassword
 *
 * @author Wesley Miranda De Oliveira
 * @since 08/08/2023, 09:32:51
 *
 */
window.blockly.js.blockly.UserControl.signUpArgs = [{ description: 'signupUsername', id: 'ec5dbe32' }, { description: 'signupEmail', id: '62cce53e' }, { description: 'signupPassword', id: 'd42229ad' }, { description: 'signupConfirmPassword', id: 'a49023f3' }];
window.blockly.js.blockly.UserControl.signUp = async function(signupUsername, signupEmail, signupPassword, signupConfirmPassword) {
 var response;
  //
  if (this.cronapi.logic.isNullOrEmpty(signupUsername)) {
    //
    this.cronapi.notification.customNotify('error', 'Digite seu nome', 'fade', 'top', 'center', 'true');
  } else if (this.cronapi.logic.isNullOrEmpty(signupEmail)) {
    //
    this.cronapi.notification.customNotify('error', 'Digite um e-mail válido', 'fade', 'top', 'center', 'true');
  } else if (signupPassword != signupConfirmPassword) {
    //
    this.cronapi.notification.customNotify('error', 'Verifique se o campo Senha e Confirmar senha estão iguais', 'fade', 'top', 'center', 'true');
  } else {
    //
    this.cronapi.util.callServerBlocklyAsynchronous('blockly.Usuario.Usuario:CadastrarUsuario', async function(sender_response) {
        response = sender_response;
      //
      if (this.cronapi.json.getProperty(response, 'sucesso')) {
        //
        this.cronapi.notification.customNotify('success', this.cronapi.json.getProperty(response, 'mensagem'), 'fade', 'top', 'center', 'true');
        //
        this.cronapi.screen.openUrl(this.cronapi.util.getBaseUrl(), null, 0, 0);
      } else {
        //
        this.cronapi.notification.customNotify('error', this.cronapi.json.getProperty(response, 'mensagem'), 'fade', 'top', 'center', 'true');
      }
    }.bind(this), signupEmail, signupPassword, signupUsername);
  }
}

/**
 * @function isValidSignup
 *
 * Descreva esta função...
 *
 * @param signupUsername
 * @param signupEmail
 * @param signupPassword
 * @param signupConfirmPassword
 *
 * @author Wesley Miranda De Oliveira
 * @since 08/08/2023, 09:32:51
 *
 */
window.blockly.js.blockly.UserControl.isValidSignupArgs = [{ description: 'signupUsername', id: 'abf7b641' }, { description: 'signupEmail', id: '38708282' }, { description: 'signupPassword', id: 'daf1486e' }, { description: 'signupConfirmPassword', id: '3f9f5d23' }];
window.blockly.js.blockly.UserControl.isValidSignup = async function(signupUsername, signupEmail, signupPassword, signupConfirmPassword) {
 var response;
  return this.cronapi.authentication.isValidSignup(signupUsername, signupEmail, signupPassword, signupConfirmPassword);
}
