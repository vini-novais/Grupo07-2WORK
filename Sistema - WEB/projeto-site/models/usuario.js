'use strict';

/* 
lista e explicação dos Datatypes:
https://codewithhugo.com/sequelize-data-types-a-practical-guide/
*/

module.exports = (sequelize, DataTypes) => {
	let Usuario = sequelize.define('Usuario', {
		idUsuario: {
			field: 'idUsuario',
			type: DataTypes.INTEGER,
			primaryKey: true,
			autoIncrement: true
		},
		cpf: {
			field: 'cpf',
			type: DataTypes.STRING,
			allowNull: false
		},
		email: {
			field: 'email',
			type: DataTypes.STRING,
			allowNull: false
		},
		nome: {
			field: 'nome',
			type: DataTypes.STRING,
			allowNull: false
		},
		online_status: {
			field: 'online_status',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		senha: {
			field: 'senha',
			type: DataTypes.STRING,
			allowNull: false
		},
		usuario_dev: {
			field: 'usuario_dev',
			type: DataTypes.INTEGER,
			allowNull: false
		},
		telefone: {
			field: 'telefone',
			type: DataTypes.STRING,
			allowNull: false
		},
		estado: {
			field: 'estado',
			type: DataTypes.STRING,
			allowNull: false
		},
		dataNascimento: {
			field: 'dataNascimento',
			type: DataTypes.STRING,
			allowNull: false
		},
		cidade: {
			field: 'cidade',
			type: DataTypes.STRING,
			allowNull: false
		}
	},
		{
			tableName: 'Usuario',
			freezeTableName: true,
			underscored: true,
			timestamps: false,
		});
	return Usuario;
};