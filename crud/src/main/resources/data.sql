insert into agent(id,code,name,person) values ('1','B1','zhangsan','张三');
insert into agent(id,code,name,person) values ('2','B2','lisi','李四');
insert into agent(id,code,name,person) values ('3','B3','wangwu','王五');

insert into bill(id,code,name,department,agent_id) values ('12','A1','xiaofen','人事部','1');
insert into bill(id,code,name,department,agent_id) values ('13','A2','linlin','销售部','1');
insert into bill(id,code,name,department,agent_id) values ('14','A3','yuki','服务部','2');
insert into bill(id,code,name,department,agent_id) values ('15','A4','wyeur','人事部','2');
insert into bill(id,code,name,department,agent_id) values ('16','A5','yujy','销售部','3');
insert into bill(id,code,name,department,agent_id) values ('17','A6','muttr','服务部','3');

insert into bill_item(id,code,name,material,bill_id) values ('34','C1','xiaoehu','材料1','12');
insert into bill_item(id,code,name,material,bill_id) values ('35','C2','turin','材料2','12');
insert into bill_item(id,code,name,material,bill_id) values ('36','C3','ruti','材料3','14');
insert into bill_item(id,code,name,material,bill_id) values ('37','C4','rung','材料4','14');
insert into bill_item(id,code,name,material,bill_id) values ('38','C5','huyong','材料5','15');
insert into bill_item(id,code,name,material,bill_id) values ('39','C6','poti','材料6','15');
