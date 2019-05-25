const ajax = (success, fail, operacao,data = null) => {
	let config;
	const urlBase = 'http://localhost:8080/cadFuncionario/';
	
	switch(operacao){
		case 'getAll':
			config = [
				`${urlBase}/ControleFuncionario`,
				{
					header: {
						"Content-Type": "text/html; charset=utf-8"
					},
					method: 'GET'
				}
			];
			break;
		case 'delete':
			config = [
				`${urlBase}/delalt?acao=excluir&id=${data}`,
				{
					header: {
						"Content-Type": "text/html; charset=utf-8"
					},
					method: 'GET'
				}
			];
			break;
		case 'criar':
			config = [
				`${urlBase}/ControleFuncionario`,
				{
					header: {
						"Content-Type": "text/html; charset=utf-8"
					},
					method: 'POST',
					body: data
				}
			];
			break
		case 'atualizar':
			config = [
				`${urlBase}/delalt?id=${data.txtId}`,
				{
					header: {
						"Content-Type": "text/html; charset=utf-8"
					},
					method: 'POST',
					body: data
				}
			];
			break
	}
	
	fetch(config[0],config[1]).then( resp => resp.text()).then( data => success(data)).catch( error => fail(error));
}

const deletarFuncionario = (e) => {

	e.preventDefault();

	let id = e.target.id.replace('funcionario-id-','');
	
	ajax(
			resp => {
				atualizaTabela();
			},
			error => console.log( 'error:', error),
			'delete',id
	);
}


const atualizaTabela = () => {
	ajax(
			resp => {
				document.getElementById('my-table-body').innerHTML = resp;
				Object.assign([], document.getElementsByClassName('del-btn')).forEach( e => e.addEventListener( 'click', deletarFuncionario));
			},
			error => console.log( 'error:', error),
			'getAll'
	);	
}

const ligaBtns = () => {
	let inputs = Object.assign([],document.querySelectorAll( `#my-form input`));
	let idPreenchido = !!inputs.shift().value;
	let todosPreenchidos = !!(inputs.length == (inputs.filter( e => e.classList.contains('valid') || (e.value == 'Ativo') || (e.value == 'Inativo')).length));
	let algumPreenchido = !!inputs.filter( e => e.value !== 'Status:').map( e => e.value).reduce((a, e) => !!a || !!e);	
	
	const atualizaBtnCancel = (flag) => {
		let btn = document.getElementById('btn-cancelar');
		if( !!flag){
			btn.removeAttribute('disabled');
		}else{
			btn.setAttribute('disabled',true);
		}
	}
	
	const atualizaBtnSaveOrUpdate = () => {
		let btnSal = document.getElementById('btn-salvar');
		let btnAtual = document.getElementById('btn-atualizar');
		
		if( idPreenchido && todosPreenchidos){
			btnAtual.parentElement.classList.remove('hide');
			btnSal.parentElement.classList.add('hide');
			btnAtual.removeAttribute('disabled')
		} else if( !idPreenchido && todosPreenchidos){
			btnSal.parentElement.classList.remove('hide');
			btnAtual.parentElement.classList.add('hide');
			btnSal.removeAttribute('disabled')
		} else if( idPreenchido && !todosPreenchidos){
			btnAtual.parentElement.classList.remove('hide');
			btnSal.parentElement.classList.add('hide');
			btnAtual.setAttribute('disabled',true);
		} else if( !idPreenchido && !todosPreenchidos){
			btnSal.parentElement.classList.remove('hide');
			btnAtual.parentElement.classList.add('hide');
			btnSal.setAttribute('disabled',true);
		}
		
	}
	atualizaBtnCancel(algumPreenchido);
	atualizaBtnSaveOrUpdate();
}

const enviaDados = (e) => {
	debugger
	e.preventDefault();
	let inputs = Object.assign([],document.querySelectorAll( `#my-form input`));
	let form = new FormData();
	
	if(! inputs[0].value){
		inputs.forEach( e => form.append( e.name, e.value));
		
		ajax(
				resp => {
					atualizaTabela();
					inputs.parentElement.reset();
				},
				error => console.log( 'error:', error),
				'criar',form
		);
	} else {
		inputs.forEach( e => form.append( e.name, e.value));
		
		ajax(
				resp => {
					atualizaTabela();
					inputs.parentElement.reset();
				},
				error => console.log( 'error:', error),
				'atualizar',form
		);
	}
	
}

const actionBtns = (elem) =>{
	if(! elem.target.hasAttribute('disabled')){
		enviaDados(elem);
	}
}


Object.assign([],document.querySelectorAll( `#my-form input`)).forEach( e => e.addEventListener( 'blur', ligaBtns));
document.getElementById('btn-salvar').addEventListener( 'click', (e) => actionBtns(e));
document.getElementById('btn-atualizar').addEventListener( 'click', (e) => actionBtns(e));
atualizaTabela();



