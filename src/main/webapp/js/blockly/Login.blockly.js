window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Login = window.blockly.js.blockly.Login || {};

/**
 * @function Login
 *
 *
 *
 *
 * @author José Zay
 * @since 29/08/2023, 09:19:35
 *
 */
window.blockly.js.blockly.Login.LoginArgs = [];
window.blockly.js.blockly.Login.Login = async function() {
 var oldPassword;
  //
  if ((await this.cronapi.client('blockly.js.blockly.Login.LoginEValido').run())) {
    //
    this.cronapi.util.executeJavascriptNoReturn('angular.element(document.getElementById(\'input-login-username\')).scope().login()');
  }
}

/**
 * @function LoginEValido
 *
 *
 *
 *
 * @author José Zay
 * @since 29/08/2023, 09:19:35
 *
 */
window.blockly.js.blockly.Login.LoginEValidoArgs = [];
window.blockly.js.blockly.Login.LoginEValido = async function() {
 var oldPassword;
  //
  loginValido = true;
  //
  email = this.cronapi.screen.getValueOfField("username.value");
  //
  senha = this.cronapi.screen.getValueOfField("password.value");
  //
  if (this.cronapi.logic.isNullOrEmpty(email)) {
    //
    loginValido = false;
    //
    this.cronapi.screen.notify('error','Preencha o E-mail.');
    //
    this.cronapi.screen.focusComponent("input-login-username");
  } else if (this.cronapi.logic.isNullOrEmpty(senha)) {
    //
    loginValido = false;
    //
    this.cronapi.screen.notify('error','Preencha a Senha.');
    //
    this.cronapi.screen.focusComponent("input-login-password");
  }
  return loginValido;
}
