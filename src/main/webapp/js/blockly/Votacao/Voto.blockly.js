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
 * @param Checado
 *
 * @author Wesley Miranda De Oliveira
 * @since 14/08/2023, 15:46:40
 *
 */
window.blockly.js.blockly.Votacao.Voto.ObtemVotoArgs = [{ description: 'idIdeiaVotada', id: '66436263' }, { description: 'Checado', id: '7b36cee4' }];
window.blockly.js.blockly.Votacao.Voto.ObtemVoto = async function(idIdeiaVotada, Checado) {
 var i, lista;
  //
  lista = this.cronapi.screen.getValueOfField("vars.listaVotos");
  //
  console.log(Checado);
  //
  if (this.cronapi.conversion.toBoolean(Checado)) {
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
    } else if (false) {
    } else {
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
