window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.auth = window.blockly.js.blockly.auth || {};
window.blockly.js.blockly.auth.ChangePassword = window.blockly.js.blockly.auth.ChangePassword || {};

/**
 * @function openModal
 *
 * ChangePassword
 *
 *
 * @author José Zay
 * @since 28/08/2023, 14:40:53
 *
 */
window.blockly.js.blockly.auth.ChangePassword.openModalArgs = [];
window.blockly.js.blockly.auth.ChangePassword.openModal = async function() {

  //
  this.cronapi.screen.showIonicModal("changePassword");
}

/**
 * @function changePassword
 *
 * Descreva esta função...
 *
 *
 * @author José Zay
 * @since 28/08/2023, 14:40:53
 *
 */
window.blockly.js.blockly.auth.ChangePassword.changePasswordArgs = [];
window.blockly.js.blockly.auth.ChangePassword.changePassword = async function() {

  //
  this.cronapi.authentication.changePassword();
}

/**
 * @function closeModal
 *
 * Descreva esta função...
 *
 *
 * @author José Zay
 * @since 28/08/2023, 14:40:53
 *
 */
window.blockly.js.blockly.auth.ChangePassword.closeModalArgs = [];
window.blockly.js.blockly.auth.ChangePassword.closeModal = async function() {

  //
  this.cronapi.screen.hideIonicModal("changePassword");
}
