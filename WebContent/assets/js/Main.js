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
				`${urlBase}/delalt?id=${data.id}`,
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
	
	fetch(...config).then( resp => resp.text()).then( data => success(data)).catch( error => fail(error));
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
	let algumPreenchido = inputs.filter( e => e.value !== 'Status:').map( e => e.value).reduce((a, e) => !!a || !!e);
	
	
}
atualizaTabela();



