/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Miguel Marcos
 * Created: 28-may-2021
 */

        
/*use instituto;*/
CREATE TABLE `instituto`
(
    `clave`     int auto_increment PRIMARY KEY,
    `nombre`    varchar(10),
    `direccion` varchar(10),
    `tlfn`      varchar(9)
);

insert into instituto.instituto(nombre, direccion, tlfn)
values ('camino', 'vacio', '979845214');


CREATE TABLE `usuario`
(
    `nombre`      varchar(10) PRIMARY KEY,
    `contra`      varchar(10),
    `DNI`         varchar(10),
    `fechaNac`    int,
    `edad`        int,
    `tipo`        varchar(3),
    `nombreInsti` varchar(10)
);
insert into instituto.usuario(nombre, contra, DNI, fechaNac, edad, tipo, nombreInsti)
values ('juan', 'juan', '123456789F', '19990917',' 21','adm','camino');
values ('dani', 'dani', '123456789D', '11111111',' 11','adm','camino');