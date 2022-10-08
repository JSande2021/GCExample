DROP TABLE IF EXISTS `item`;

CREATE TABLE `item` (
  `id` mediumint(8) unsigned NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  `price` varchar(100) default NULL,
  `description` TEXT default NULL,
  PRIMARY KEY (`id`)
) AUTO_INCREMENT=1;

INSERT INTO `item` (`name`,`price`,`description`)
VALUES
  ("Robertson","688.32","orci sem eget massa. Suspendisse eleifend. Cras sed leo. Cras vehicula aliquet libero. Integer"),
  ("Robertson","888.85","ut erat. Sed nunc est, mollis non, cursus non, egestas a, dui. Cras pellentesque."),
  ("Ruiz","144.47","ipsum ac mi eleifend egestas. Sed pharetra, felis eget varius ultrices, mauris ipsum porta"),
  ("Hull","827.60","eros. Proin ultrices. Duis volutpat nunc sit amet metus. Aliquam erat volutpat. Nulla facilisis."),
  ("Britt","983.59","urna. Nunc quis arcu vel quam dignissim pharetra. Nam ac nulla. In tincidunt congue"),
  ("Patrick","755.21","Vestibulum ut eros non enim commodo hendrerit. Donec porttitor tellus non magna. Nam ligula"),
  ("Harrison","614.56","molestie pharetra nibh. Aliquam ornare, libero at auctor ullamcorper, nisl arcu iaculis enim, sit"),
  ("Parsons","653.59","egestas. Duis ac arcu. Nunc mauris. Morbi non sapien molestie orci tincidunt adipiscing. Mauris"),
  ("Medina","254.76","eget ipsum. Suspendisse sagittis. Nullam vitae diam. Proin dolor. Nulla semper tellus id nunc"),
  ("Rivas","88.73","nisi dictum augue malesuada malesuada. Integer id magna et ipsum cursus vestibulum. Mauris magna.");
INSERT INTO `item` (`name`,`price`,`description`)
VALUES
  ("Ray","256.03","imperdiet nec, leo. Morbi neque tellus, imperdiet non, vestibulum nec, euismod in, dolor. Fusce"),
  ("Bray","362.82","Vivamus rhoncus. Donec est. Nunc ullamcorper, velit in aliquet lobortis, nisi nibh lacinia orci,"),
  ("Kidd","679.55","cursus. Integer mollis. Integer tincidunt aliquam arcu. Aliquam ultrices iaculis odio. Nam interdum enim"),
  ("Chang","606.15","nisi nibh lacinia orci, consectetuer euismod est arcu ac orci. Ut semper pretium neque."),
  ("connor","890.72","a, auctor non, feugiat nec, diam. Duis mi enim, condimentum eget, volutpat ornare, facilisis"),
  ("Kelley","96.19","ultrices iaculis odio. Nam interdum enim non nisi. Aenean eget metus. In nec orci."),
  ("Sanders","656.97","orci, adipiscing non, luctus sit amet, faucibus ut, nulla. Cras eu tellus eu augue"),
  ("rujillo","126.95","convallis, ante lectus convallis est, vitae sodales nisi magna sed dui. Fusce aliquam, enim"),
  ("Shields","449.89","quam a felis ullamcorper viverra. Maecenas iaculis aliquet diam. Sed diam lorem, auctor quis,"),
  ("Wallace","241.35","Proin sed turpis nec mauris blandit mattis. Cras eget nisi dictum augue malesuada malesuada.");
INSERT INTO `item` (`name`,`price`,`description`)
VALUES
  ("Conrad","204.20","Quisque fringilla euismod enim. Etiam gravida molestie arcu. Sed eu nibh vulputate mauris sagittis"),
  ("Roberts","24.40","lorem lorem, luctus ut, pellentesque eget, dictum placerat, augue. Sed molestie. Sed id risus"),
  ("Fernandez","986.54","cursus et, eros. Proin ultrices. Duis volutpat nunc sit amet metus. Aliquam erat volutpat."),
  ("Mays","22.02","porttitor tellus non magna. Nam ligula elit, pretium et, rutrum non, hendrerit id, ante."),
  ("Lowe","123.00","tincidunt nibh. Phasellus nulla. Integer vulputate, risus a ultricies adipiscing, enim mi tempor lorem,"),
  ("Bender","748.28","lobortis tellus justo sit amet nulla. Donec non justo. Proin non massa non ante"),
  ("Lyons","705.46","tellus. Nunc lectus pede, ultrices a, auctor non, feugiat nec, diam. Duis mi enim,"),
  ("Harvey","448.73","lorem ut aliquam iaculis, lacus pede sagittis augue, eu tempor erat neque non quam."),
  ("Pearson","448.83","gravida non, sollicitudin a, malesuada id, erat. Etiam vestibulum massa rutrum magna. Cras convallis"),
  ("Shaw","89.50","ut aliquam iaculis, lacus pede sagittis augue, eu tempor erat neque non quam. Pellentesque");
