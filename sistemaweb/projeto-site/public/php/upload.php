<?php
$file_name = $_FILES['file']['name']; // OBTENDO O NOME DO ARQUIVO
$tmp_name = $_FILES['file']['tmp_name']; // OBTENDO temp_name DO ARQUIVO
$file_up_name = time().$file_name; // TORNANDO O NOME DO ARQUIVO DINÂMICO ADICIONANDO TEMPO ANTES DO NOME DO ARQUIVO
move_uploaded_file($tmp_name, "files/".$file_up_name); // MOVENDO O ARQUIVO PARA A PASTA ESPECIFICADA COM DINÂMICA
?>