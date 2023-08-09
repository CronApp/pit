window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.EditarPerfil = window.blockly.js.blockly.EditarPerfil || {};
window.blockly.js.blockly.EditarPerfil.EditarPerfil = window.blockly.js.blockly.EditarPerfil.EditarPerfil || {};

/**
 * @function FecharModalEditarPerfil
 *
 *
 *
 *
 * @author Wesley Miranda De Oliveira
 * @since 08/08/2023, 10:50:36
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.FecharModalEditarPerfilArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.FecharModalEditarPerfil = async function() {

  //
  this.cronapi.screen.hideModal("modalEdicaoPerfil");
}

/**
 * @function IniciarModalEditar
 *
 *
 *
 *
 * @author Wesley Miranda De Oliveira
 * @since 08/08/2023, 10:50:36
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditarArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditar = async function() {

  //
  this.cronapi.screen.showModal("modalEdicaoPerfil");
}

/**
 * @function IniciarModalEditarSenha
 *
 *
 *
 *
 * @author Wesley Miranda De Oliveira
 * @since 08/08/2023, 10:50:36
 *
 */
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditarSenhaArgs = [];
window.blockly.js.blockly.EditarPerfil.EditarPerfil.IniciarModalEditarSenha = async function() {

  //
  this.cronapi.screen.showModal("modalPassword");
  //
  this.cronapi.screen.hideModal("modalEdicaoPerfil");
}
