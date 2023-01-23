insert into accounts(id, first_name, last_name, email, password, username)
values(100, 'Thierry', 'Marcelin', 'marcelinthierry@gmail.com', 'MaySouMayOh', 'thierrymarcelin');
insert into accounts(id, first_name, last_name, email, password, username)
values(101, 'Fabrice', 'Marcelin', 'fmarcelin@gmail.com', 'SyelLaPaPiyay', 'fmarcelin');
insert into accounts(id, first_name, last_name, email, password, username)
values(102, 'Martine', 'Marcelin', 'martine.s.marcelin@gmail.com', 'Cancer1979', 'msmarcelin');


insert into occupations(id, name) values(1, 'Software Developer');
insert into occupations(id, name) values(2, 'Doctor');
insert into occupations(id, name) values(3, 'Civil Engineer');
insert into occupations(id, name) values(4, 'Chemist');
insert into occupations(id, name) values(5, 'Soccer Player');

insert into requests(id, requestor_id, title, description, amount, location, is_active)
values(1000, 100, 'Find me in the club, bottle full of bub',
       'A Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat ' ||
       'non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 1500, 'USA',true);
insert into requests(id, requestor_id, title, description, amount, location, is_active)
values(1001, 100, 'Needs help with my Car',
       'A little help with my car. It broke down on the I-95', 500, 'Canada', true);
insert into requests(id, requestor_id, title, description, amount, location, is_active)
values(1002, 100, 'Anmeyyy gadon plezi',
       'Bezwen al nan kanaval mw menm', 250, 'Haiti', true);
insert into requests(id, requestor_id, title, description, amount, location, is_active)
values(1003, 100, 'I can Transform Ya',
       'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat ' ||
       'non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.', 2430, 'Canada',true);
insert into requests(id, requestor_id, title, description, amount, location, is_active)
values(1004, 100, 'I want to buy the latest iPhone 14 Pro Max',
       'Nncididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat',
       999, 'Taiwan', true);
insert into requests(id, requestor_id, title, description, amount, location, is_active)
values(1005, 101, 'DevOps MasterClass',
       'Need Help Buying the latest DevOps class on Udacity', 410, 'Canada',true);
insert into requests(id, requestor_id, title, description, amount, location, is_active)
values(1006, 101, 'New Tesla Car',
       'I always wanted to buy the latest Tesla S-Plain since 2015, but could not afford it', 10000, 'Canada', true);
insert into requests(id, requestor_id, title, description, amount, location, is_active)
values(1007, 102, 'Moving to Canada (Quebec)',
      'I need to be able to afford paying for my university fees, but saying it is expensive would be an understatement', 10000, 'Haiti',true);


