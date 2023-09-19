window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.ResetSenha = window.blockly.js.blockly.ResetSenha || {};
window.blockly.js.blockly.ResetSenha.ResetSenha = window.blockly.js.blockly.ResetSenha.ResetSenha || {};

/**
 * @function Resetar
 *
 *
 *
 * @param reset
 *
 * @author José Zay
 * @since 19/09/2023, 16:59:36
 *
 */
window.blockly.js.blockly.ResetSenha.ResetSenha.ResetarArgs = [{ description: 'reset', id: 'f6c4f75c' }];
window.blockly.js.blockly.ResetSenha.ResetSenha.Resetar = async function(reset) {

  //
  (await this.cronapi.server('blockly.Usuario.ResetSenha.Resetar').names('7b749659').toPromise().run(reset));
}
