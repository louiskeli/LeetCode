//表1: Person 
//
// +-------------+---------+
//| 列名         | 类型     |
//+-------------+---------+
//| PersonId    | int     |
//| FirstName   | varchar |
//| LastName    | varchar |
//+-------------+---------+
//PersonId 是上表主键
// 
//
// 表2: Address 
//
// +-------------+---------+
//| 列名         | 类型    |
//+-------------+---------+
//| AddressId   | int     |
//| PersonId    | int     |
//| City        | varchar |
//| State       | varchar |
//+-------------+---------+
//AddressId 是上表主键
// 
//
// 
//
// 编写一个 SQL 查询，满足条件：无论 person 是否有地址信息，都需要基于上述两表提供 person 的以下信息： 
//
// 
//
// FirstName, LastName, City, State
// 
// 👍 671 👎 0


//There is no code of Java type for this problem
select FirstName,LastName,City,State
from Person left join Address
on Person.personId = Address.PersonId
;
//因为表 Address 中的 personId 是表 Person 的外关键字，所以我们可以连接这两个表来获取一个人的地址信息。
//考虑到可能不是每个人都有地址信息，应该使用 outer join 而不是默认的 inner join。