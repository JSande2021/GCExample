DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userId` mediumint(8) unsigned NOT NULL auto_increment,
  `userName` varchar(255) default NULL,
  `userPassword` varchar(255) default NULL,
  PRIMARY KEY (`userId`)
) AUTO_INCREMENT=1;

INSERT INTO `user` (`userName`,`userPassword`)
VALUES
  ("Admin","Admin"),
  ("LeeMaddox","Briggs"),
  ("BevisWhite","Rhodes"),
  ("MaconCalhoun","Crosby"),
  ("FeliciaClay","Harrington"),
  ("CraigRios","Cummings"),
  ("YuriHolder","Wiggins"),
  ("AdriaWebb","Mclean"),
  ("PorterSpencer","Bryan"),
  ("IllianaDillon","Bush");
INSERT INTO `user` (`userName`,`userPassword`)
VALUES
  ("MinervaValentine","Zelda"),
  ("Shelliery","Petty"),
  ("ColtBowers","Patterson"),
  ("MechelleGarrett","Ellis"),
  ("GilClemons","Bray"),
  ("KatellBenson","Frank"),
  ("DavidLowery","Iris"),
  ("ZiaMccarty","Nieves"),
  ("GloriaGilliam","Gentry"),
  ("IvorMccray","Wolfe");
