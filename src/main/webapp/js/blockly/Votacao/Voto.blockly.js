window.blockly = window.blockly || {};
window.blockly.js = window.blockly.js || {};
window.blockly.js.blockly = window.blockly.js.blockly || {};
window.blockly.js.blockly.Votacao = window.blockly.js.blockly.Votacao || {};
window.blockly.js.blockly.Votacao.Voto = window.blockly.js.blockly.Votacao.Voto || {};

/**
 * @function IniciarVotacao
 *
 *
 *
 * @param checkAceitarRegras
 * @param checkbox
 *
 * @author José Zay
 * @since 16/08/2023, 14:51:01
 *
 */
window.blockly.js.blockly.Votacao.Voto.IniciarVotacaoArgs = [{ description: 'checkAceitarRegras', id: 'b8644fae' }, { description: 'checkbox', id: '77b0ad38' }];
window.blockly.js.blockly.Votacao.Voto.IniciarVotacao = async function(checkAceitarRegras, checkbox) {
 var x, i, lista;
  //
  checkAceitarRegras = !this.cronapi.conversion.toBoolean(checkAceitarRegras);
  //
  if (checkAceitarRegras) {
    //
    this.cronapi.screen.toggleClass("div-tela1-id", 'hidden');
    //
    this.cronapi.screen.toggleClass("div-tela2-id", 'hidden');
    //
    console.log(this.cronapi.screen.getValueOfField("vars.listaIdeias"));
    //
    var i_list = this.cronapi.screen.getValueOfField("vars.listaIdeias");
    for (var i_index in i_list) {
      i = i_list[i_index];
      //
      this.cronapi.screen.toggleClass(String('div-check-voto-') + String((this.cronapi.screen.getValueOfField("vars.listaIdeias").indexOf(i) + 1 - 1)), 'hidden');
    }
  } else {
  }
}

/**
 * @function ObtemVoto
 *
 *
 *
 * @param idIdeiaVotada
 * @param checado
 *
 * @author José Zay
 * @since 16/08/2023, 14:51:01
 *
 */
window.blockly.js.blockly.Votacao.Voto.ObtemVotoArgs = [{ description: 'idIdeiaVotada', id: '66436263' }, { description: 'checado', id: '7b36cee4' }];
window.blockly.js.blockly.Votacao.Voto.ObtemVoto = async function(idIdeiaVotada, checado) {
 var x, checkAceitarRegras, checkbox;
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
