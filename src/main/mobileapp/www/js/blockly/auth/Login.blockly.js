window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.auth = window.blockly.js.blockly.auth || {};
window.blockly.js.blockly.auth.Login = window.blockly.js.blockly.auth.Login || {};

/**
 * @function login
 *
 * Login
 *
 * @param login
 * @param password
 * @param options
 *
 * @author Wesley Miranda De Oliveira
 * @since 11/08/2023, 08:56:20
 *
 */
window.blockly.js.blockly.auth.Login.loginArgs = [{ description: 'login', id: '73d65812' }, { description: 'password', id: '0b973243' }, { description: 'options', id: '5ae2f195' }];
window.blockly.js.blockly.auth.Login.login = async function(login, password, options) {

  //
  this.cronapi.authentication.login(login, password, options);
  //
  this.cronapi.screen.notify('success','AAAAAAAAAAAAAAAAAAAAAAAAAAAAA');
}
