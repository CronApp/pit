window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.MutualAuth = window.blockly.js.blockly.MutualAuth || {};

/**
 * @function login
 *
 * MutualAuth
 *
 *
 * @author Wesley Miranda De Oliveira
 * @since 11/08/2023, 08:56:52
 *
 */
window.blockly.js.blockly.MutualAuth.loginArgs = [];
window.blockly.js.blockly.MutualAuth.login = async function() {

  //
  (await this.cronapi.client('cronapi.authentication.mutualLogin').run());
  //
  this.cronapi.screen.notify('success','aaaaaaa');
}

/**
 * @function signup
 *
 * Descreva esta função...
 *
 *
 * @author Wesley Miranda De Oliveira
 * @since 11/08/2023, 08:56:52
 *
 */
window.blockly.js.blockly.MutualAuth.signupArgs = [];
window.blockly.js.blockly.MutualAuth.signup = async function() {

  //
  (await this.cronapi.client('cronapi.authentication.mutualSignup').run());
}
