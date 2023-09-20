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
 * @param senha
 * @param confirmarSenha
 *
 * @author José Zay
 * @since 20/09/2023, 08:10:04
 *
 */
window.blockly.js.blockly.ResetSenha.ResetSenha.ResetarArgs = [{ description: 'reset', id: 'f6c4f75c' }, { description: 'senha', id: '81971ea4' }, { description: 'confirmarSenha', id: 'cf594f7c' }];
window.blockly.js.blockly.ResetSenha.ResetSenha.Resetar = async function(reset, senha, confirmarSenha) {
 var item;
  //
  item = (await this.cronapi.server('blockly.Usuario.ResetSenha.Resetar').names('7b749659', '972945ce', '864be41c').toPromise().run(reset, senha, confirmarSenha));
  //
  if (this.cronapi.object.getProperty(item, 'sucesso')) {
    //
    this.cronapi.screen.notify('success',this.cronapi.object.getProperty(item, 'mensagem'));
    //
    this.cronapi.screen.changeView("#/home/login",[  ]);
  } else {
    //
    this.cronapi.screen.notify('error',this.cronapi.object.getProperty(item, 'mensagem'));
  }
  //
  console.log(item);
}
