var express = require('express');
var router = express.Router();
var sequelize = require('../models').sequelize;
var Usuario = require('../models').Usuario;

let sessoes = [];

/* RECUPERAR USUÁRIO POR LOGIN E SENHA */
router.post('/autenticar', function (req, res, next) {
	console.log('Recuperando usuário por login e senha');

	var email = req.body.email; // DEPOIS DE .body, USE O NOME (name) DO CAMPO EM SEU FORMULÁRIO DE LOGIN
	var senha = req.body.senha; // DEPOIS DE .body, USE O NOME (name) DO CAMPO EM SEU FORMULÁRIO DE LOGIN

	let instrucaoSql = `select * from usuario where email='${email}' and senha='${senha}'`;

	console.log(instrucaoSql);

	sequelize.query(instrucaoSql, {
		model: Usuario
	}).then(resultado => {
		console.log(`Encontrados: ${resultado.length}`);

		if (resultado.length == 1) {
			sessoes.push(resultado[0].dataValues.email);
			console.log('sessoes: ', sessoes);
			res.json(resultado[0]);
		} else if (resultado.length == 0) {
			res.status(403).send('E-mail e/ou senha inválido(s)');
		} else {
			res.status(403).send('Mais de um usuário com o mesmo e-mail e senha!');
		}
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});
/* FIM RECUPERAR USUÁRIO POR LOGIN E SENHA */

/* CADASTRAR USUÁRIO */
router.post('/cadastrar', function (req, res, next) {
	console.log('Criando um usuário');

	Usuario.create({
		cpf: req.body.cpf,
		email: req.body.email,
		nome: req.body.nome,
		online_status: 0,
		senha: req.body.senha1,
		usuario_dev: 0,
		telefone: req.body.telefone,
		estado: req.body.estado,
		dataNascimento: req.body.dataNascimento,
		cidade: req.body.cidade
	}).then(resultado => {
		console.log(`Registro criado: ${resultado}`)
		res.send(resultado);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});
/* FIM CADASTRAR USUÁRIO */

/* VERIFICAÇÃO DE USUÁRIO */
router.get('/sessao/:login', function (req, res, next) {
	let email = req.params.email;
	console.log(`Verificando se o usuário ${email} tem sessão`);
	let tem_sessao = false;

	for (let u = 0; u < sessoes.length; u++) {
		if (sessoes[u] == email) {
			tem_sessao = true;
			break;
		}
	}
	if (tem_sessao) {
		let mensagem = `Usuário ${email} possui sessão ativa!`;
		console.log(mensagem);
		res.send(mensagem);
	} else {
		res.sendStatus(403);
	}
});
/* FIM VERIFICAÇÃO DE USUÁRIO */

/* LOGOFF DE USUÁRIO */
router.get('/sair/:login', function (req, res, next) {
	let email = req.params.email;
	console.log(`Finalizando a sessão do usuário ${email}`);
	let nova_sessoes = []

	for (let u = 0; u < sessoes.length; u++) {
		if (sessoes[u] != email) {
			nova_sessoes.push(sessoes[u]);
		}
	}
	sessoes = nova_sessoes;
	res.send(`Sessão do usuário ${email} finalizada com sucesso!`);
});
/* FIM LOGOFF DE USUÁRIO */

/* RECUPERAR TODOS OS USUÁRIOS */
router.get('/', function (req, res, next) {
	console.log('Recuperando todos os usuários');

	Usuario.findAndCountAll().then(resultado => {
		console.log(`${resultado.count} registros`);
		res.json(resultado.rows);
	}).catch(erro => {
		console.error(erro);
		res.status(500).send(erro.message);
	});
});
/* FIM RECUPERAR TODOS OS USUÁRIOS */

module.exports = router;