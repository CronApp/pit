window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Votacao = window.blockly.js.blockly.Votacao || {};
window.blockly.js.blockly.Votacao.Voto = window.blockly.js.blockly.Votacao.Voto || {};

/**
 * @function ObtemVoto
 *
 *
 *
 * @param idIdeiaVotada
 * @param checado
 *
 * @author Wesley Miranda De Oliveira
 * @since 15/08/2023, 16:25:27
 *
 */
window.blockly.js.blockly.Votacao.Voto.ObtemVotoArgs = [{ description: 'idIdeiaVotada', id: '66436263' }, { description: 'checado', id: '7b36cee4' }];
window.blockly.js.blockly.Votacao.Voto.ObtemVoto = async function(idIdeiaVotada, checado) {
 var hecado, i, x, lista;
  //
  lista = this.cronapi.screen.getValueOfField("vars.listaVotos");
  //
  console.log(checado);
  //
  if (this.cronapi.conversion.toBoolean(checado)) {
    //
    if (this.cronapi.logic.isNullOrEmpty(lista)) {
      //
      lista = [];
      //
      lista.unshift(idIdeiaVotada);
      //
      this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
    } else if (lista.length < 2) {
      //
      lista.push(idIdeiaVotada);
      //
      this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
    } else {
      //
      this.cronapi.screen.notify('success','Selecione no máximo 2 caixas de seleção');
    }
  } else {
    //
    lista.splice(((lista.indexOf(idIdeiaVotada) + 1) - 1), 1);
    //
    console.log(lista.indexOf(idIdeiaVotada) + 1);
    //
    this.cronapi.screen.changeValueOfField("vars.listaVotos", lista);
  }
  //
  console.log(lista);
}
