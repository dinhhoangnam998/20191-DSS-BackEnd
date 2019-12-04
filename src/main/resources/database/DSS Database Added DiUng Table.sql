-- MySQL dump 10.13  Distrib 8.0.16, for Win64 (x86_64)
--
-- Host: localhost    Database: decisionsuportdb
-- ------------------------------------------------------
-- Server version	8.0.16

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `di_ung`
--

DROP TABLE IF EXISTS `di_ung`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `di_ung` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `di_ung`
--

LOCK TABLES `di_ung` WRITE;
/*!40000 ALTER TABLE `di_ung` DISABLE KEYS */;
INSERT INTO `di_ung` VALUES (1,'hành tây'),(2,'tiêu đen'),(3,'cá lóc'),(4,'hành'),(5,'Cua'),(6,'húng');
/*!40000 ALTER TABLE `di_ung` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mon_an`
--

DROP TABLE IF EXISTS `mon_an`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mon_an` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `do_cay` int(11) NOT NULL,
  `do_dinh_duong` int(11) NOT NULL,
  `do_ngot` int(11) NOT NULL,
  `do_pho_bien` int(11) NOT NULL,
  `gia` int(11) NOT NULL,
  `mota` varchar(255) DEFAULT NULL,
  `ten` varchar(255) DEFAULT NULL,
  `nguon_goc_id` int(11) DEFAULT NULL,
  `the_loai_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK53j7enjokg2fyphltyju70m9v` (`nguon_goc_id`),
  KEY `FKg3fhij0w67oxpuguktv6piib8` (`the_loai_id`),
  CONSTRAINT `FK53j7enjokg2fyphltyju70m9v` FOREIGN KEY (`nguon_goc_id`) REFERENCES `quoc_gia` (`id`),
  CONSTRAINT `FKg3fhij0w67oxpuguktv6piib8` FOREIGN KEY (`the_loai_id`) REFERENCES `the_loai` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon_an`
--

LOCK TABLES `mon_an` WRITE;
/*!40000 ALTER TABLE `mon_an` DISABLE KEYS */;
INSERT INTO `mon_an` VALUES (1,8,1,8,737,100,'','Som tam',12,8),(2,3,9,6,748,200,'','Cơm gà',11,6),(3,5,1,4,716,100,'','Bánh mì nướng',4,1),(4,6,5,4,600,1000,'','Cua ớt',11,3),(5,6,0,0,593,100,'','Gỏi cuốn',15,8),(6,9,5,0,558,500,'','Steak Ohmi-gyu',8,2),(7,3,6,0,318,100,'','Phở',15,15),(8,8,4,1,619,1000,'','Lechón',10,12),(9,7,1,5,489,500,'','Rendang',5,2),(10,7,5,2,649,300,'','Tom yum goong',12,22),(11,0,8,4,57,200,'','Penang assam laksa',6,14),(12,2,6,6,517,500,'','Vịt quay Bắc Kinh',2,23),(13,2,5,1,50,200,'','Sushi',8,17),(14,8,7,9,844,200,'','Massaman curry',12,4),(15,5,1,7,673,200,'','Cơm trộn',3,6),(16,7,4,1,783,200,'','Cơm cuốn lá rong biển',3,6),(17,8,1,1,617,100,'','Mỳ lạnh',3,14),(18,8,7,2,495,300,'','Gà tần sâm',3,7),(19,5,9,4,841,200,'','Đậu phụ hầm cay',3,9),(20,7,7,4,41,100,'','Miến trộn Hàn Quốc',3,13),(21,9,2,6,818,200,'','Sườn nướng',3,19),(22,1,3,4,239,400,'','Thị bò nướng',3,2),(23,3,2,7,129,200,'','Bánh hải sản',3,16),(24,2,7,1,196,100,'','Kimchi',3,11),(25,2,5,1,642,100,'','Bánh bí đỏ',3,NULL),(26,4,3,9,11,150,'','Cơm chiên cá mặn',15,6),(27,7,7,8,459,150,'','Cơm gà lá sen',15,6),(28,9,3,9,410,150,'','Cơm chiên Dương Châu',15,6),(29,0,5,2,816,160,'','Súp đông cô gà xé',15,18),(30,4,3,6,564,450,'','Súp vi cá',15,18),(31,1,6,3,534,160,'','Súp hải sản',15,18),(32,1,4,9,739,160,'','Súp sò điệp',15,18),(33,6,2,2,473,210,'','Gỏi bò bóp thấu',15,8),(34,8,1,2,403,210,'','Gỏi tôm',15,8),(35,8,0,1,681,300,'','Gỏi bò ngũ sắc',15,8),(36,1,6,6,553,250,'','Gỏi gân bò',15,8),(37,9,3,3,341,150,'','Gỏi sứa',15,8),(38,6,5,0,474,400,'','Tôm càng sốt me',15,22),(39,1,9,3,663,500,'','Tôm hùm Sashimi',8,22),(40,6,9,6,665,500,'','Tôm hùm bỏ lò phomai',9,22),(41,1,7,2,818,100,'','Tiết canh tôm hùm',15,22),(42,7,4,6,14,500,'','Tôm hùm nướng',15,22),(43,1,0,1,250,400,'','Cháo tôm hùm',15,22),(44,0,5,2,242,400,'','Bò hầm nấm',9,2),(45,6,9,5,458,300,'','Bò nấu tiêu đen',9,2),(46,4,1,5,159,400,'','Thịt bò sống parisa',9,2),(47,1,6,1,411,350,'','Bò bít tết',9,2),(48,9,5,5,833,290,'','Cá diêu hồng sốt chanh dây',15,5),(49,0,2,5,409,290,'','Cá lóc quay me – Bánh hỏi',15,5),(50,2,9,4,407,300,'','Lẩu cháo cá lóc',15,5),(51,6,3,9,461,600,'','Cá bống mú hấp HongKong',NULL,5),(52,3,1,1,61,650,'','Cá bống mú hấp Thượng Hải',13,5),(53,6,3,5,755,600,'','Cá bống mú gấp gừng',15,5),(54,1,2,2,296,200,'','Cá kho tộ',15,5),(55,1,6,4,89,300,'','Gà bó xôi truyền thống',15,7),(56,5,3,4,103,400,'','Gà ta hấp cách thủy',15,7),(57,0,9,6,250,400,'','Gà tiềm hạt sen',15,7),(58,5,0,4,740,500,'','Gà quay ngũ vị',15,7),(59,3,4,6,735,500,'','Gà quay bó xôi chà bông',15,7),(60,5,1,1,726,500,'','Gà bó xôi 3 màu ôm trứng non hạt sen',15,7),(61,6,8,1,724,700,'','Gà nướng phomai',3,7),(62,5,2,8,366,600,'','Gà ăn mày',14,7),(63,1,1,0,791,600,'','Gà Kung Pao',14,7),(64,1,9,0,297,500,'','Cơm gà Hải Nam',11,7),(65,9,8,3,416,200,'','Gà rán',7,7),(66,1,2,5,22,200,'','Thịt heo chiên xóc tỏi',15,21),(67,2,6,0,366,150,'','Thịt heo hầm cà rốt',15,21),(68,6,3,0,75,200,'','Thịt heo bọc sả chiên giòn',15,21),(69,9,7,0,489,100,'','Thịt heo rang muối ớt',15,21),(70,2,9,6,585,200,'','Thịt heo cuộn măng hầm',15,21),(71,5,3,7,714,250,'','Thịt heo xào lăng',15,21),(72,9,0,7,312,1000,'','Heo sữa quay',9,21),(73,9,6,6,468,400,'','Thịt heo chiên giòn',1,21),(74,1,3,0,426,150,'','Sườn xào chua ngọt',15,19),(75,0,3,2,478,300,'','Thịt heo xào kim chi',3,21),(76,4,6,3,479,400,'','Dê ủ trấu',15,20),(77,2,4,4,56,500,'','Chân dê hầm thuốc bắc',14,20),(78,3,8,5,645,450,'','Dê hấp',15,20),(79,0,7,4,201,450,'','Nầm dê nướng',15,20),(80,6,7,9,663,450,'','Dê nướng mọi',15,20),(81,2,0,4,84,500,'','Dê nướng ngũ vị',15,20),(82,0,5,7,603,150,'','Chả hoàng kim',NULL,10),(83,9,5,6,245,150,'','Hải sản tam giác vàng',NULL,10);
/*!40000 ALTER TABLE `mon_an` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mon_an_nguyen_lieu`
--

DROP TABLE IF EXISTS `mon_an_nguyen_lieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `mon_an_nguyen_lieu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `mon_an_id` int(11) DEFAULT NULL,
  `nguyen_lieu_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FKesrsca1e332qape5xx1dbxam2` (`mon_an_id`),
  KEY `FKs4rwedw7u1gldu9gexxnj6q9f` (`nguyen_lieu_id`),
  CONSTRAINT `FKesrsca1e332qape5xx1dbxam2` FOREIGN KEY (`mon_an_id`) REFERENCES `mon_an` (`id`),
  CONSTRAINT `FKs4rwedw7u1gldu9gexxnj6q9f` FOREIGN KEY (`nguyen_lieu_id`) REFERENCES `nguyen_lieu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=328 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mon_an_nguyen_lieu`
--

LOCK TABLES `mon_an_nguyen_lieu` WRITE;
/*!40000 ALTER TABLE `mon_an_nguyen_lieu` DISABLE KEYS */;
INSERT INTO `mon_an_nguyen_lieu` VALUES (1,1,152),(2,1,87),(3,1,71),(4,1,153),(5,1,154),(6,1,155),(7,1,156),(8,1,16),(9,1,94),(10,2,66),(11,2,46),(12,2,9),(13,3,17),(14,3,18),(15,3,19),(16,3,5),(17,3,20),(18,4,30),(19,4,16),(20,4,31),(21,4,5),(22,5,144),(23,5,2),(24,5,29),(25,5,145),(26,6,4),(27,6,117),(28,6,118),(29,7,1),(30,7,2),(31,7,3),(32,7,4),(33,7,3),(34,8,95),(35,9,4),(36,9,119),(37,9,51),(38,9,94),(39,9,120),(40,9,36),(41,9,16),(42,10,157),(43,10,13),(44,10,71),(45,10,51),(46,10,159),(47,11,49),(48,11,47),(49,11,16),(50,11,50),(51,11,51),(52,11,6),(53,11,52),(54,11,53),(55,12,161),(56,12,145),(57,12,6),(58,12,162),(59,13,45),(60,13,46),(61,14,32),(62,14,33),(63,15,46),(64,15,19),(65,15,61),(66,15,9),(67,15,7),(68,15,62),(69,15,63),(70,16,46),(71,16,57),(72,16,58),(73,16,7),(74,16,2),(75,17,53),(76,17,97),(77,17,19),(78,17,16),(79,17,9),(80,17,98),(81,18,55),(82,18,72),(83,18,73),(84,18,74),(85,18,75),(86,19,163),(87,19,164),(88,19,13),(89,19,23),(90,20,96),(91,20,12),(92,20,4),(93,20,84),(94,21,106),(95,21,2),(96,22,4),(97,22,121),(98,22,92),(99,22,122),(100,23,78),(101,23,91),(102,23,141),(103,23,148),(104,24,93),(105,24,23),(106,24,94),(107,24,16),(108,24,36),(109,25,99),(110,25,NULL),(111,25,101),(112,26,46),(113,26,54),(114,26,31),(115,27,46),(116,27,55),(117,27,56),(118,28,46),(119,28,59),(120,28,60),(121,28,7),(122,29,137),(123,29,138),(124,30,160),(125,30,2),(126,31,89),(127,31,90),(128,31,2),(129,32,105),(130,32,2),(131,32,56),(132,33,8),(133,33,7),(134,33,4),(135,33,104),(136,33,6),(137,33,2),(138,34,157),(139,34,71),(140,34,79),(141,34,158),(142,35,5),(143,35,6),(144,35,7),(145,35,8),(146,35,9),(147,36,86),(148,36,87),(149,36,9),(150,36,16),(151,36,2),(152,37,108),(153,37,104),(154,37,87),(155,37,8),(156,37,7),(157,37,2),(158,38,149),(159,38,47),(160,38,79),(161,39,24),(162,39,16),(163,39,2),(164,39,151),(165,40,24),(166,40,79),(167,40,150),(168,41,146),(169,41,87),(170,41,2),(171,41,26),(172,41,147),(173,42,24),(174,42,16),(175,42,94),(176,42,51),(177,42,25),(178,43,21),(179,43,24),(180,43,25),(181,43,26),(182,44,5),(183,44,13),(184,44,5),(185,44,12),(186,45,5),(187,45,6),(188,45,10),(189,45,11),(190,45,12),(191,46,5),(192,46,14),(193,46,15),(194,46,16),(195,47,4),(196,47,116),(197,47,23),(198,47,94),(199,48,43),(200,48,44),(201,48,5),(202,48,2),(203,49,22),(204,49,47),(205,49,48),(206,49,2),(207,50,21),(208,50,22),(209,50,2),(210,50,23),(211,50,19),(212,51,34),(213,51,38),(214,51,39),(215,51,36),(216,52,34),(217,52,37),(218,52,13),(219,52,16),(220,53,34),(221,53,35),(222,53,36),(223,54,40),(224,54,41),(225,54,36),(226,54,42),(227,55,55),(228,55,69),(229,56,55),(230,56,78),(231,56,79),(232,56,12),(233,57,67),(234,57,7),(235,57,2),(236,58,55),(237,58,12),(238,58,77),(239,59,55),(240,59,68),(241,59,69),(242,60,55),(243,60,80),(244,60,81),(245,60,82),(246,61,137),(247,61,139),(248,61,140),(249,62,55),(250,62,76),(251,63,55),(252,63,16),(253,63,83),(254,63,36),(255,63,84),(256,63,85),(257,64,55),(258,64,46),(259,64,70),(260,64,71),(261,65,55),(262,66,112),(263,66,113),(264,66,114),(265,66,115),(266,67,102),(267,67,7),(268,67,36),(269,67,94),(270,67,141),(271,68,111),(272,68,23),(273,68,94),(274,68,51),(275,69,102),(276,69,16),(277,69,143),(278,69,23),(279,70,102),(280,70,142),(281,70,13),(282,70,113),(283,71,109),(284,71,51),(285,71,16),(286,71,94),(287,71,110),(288,72,88),(289,72,82),(290,73,102),(291,74,107),(292,74,16),(293,75,102),(294,75,93),(295,76,64),(296,76,65),(297,77,27),(298,77,28),(299,77,29),(300,78,123),(301,78,134),(302,78,135),(303,78,132),(304,78,136),(305,78,52),(306,79,123),(307,79,21),(308,79,124),(309,79,125),(310,79,51),(311,79,94),(312,79,126),(313,80,123),(314,80,129),(315,80,130),(316,80,131),(317,80,132),(318,80,133),(319,81,123),(320,81,127),(321,81,128),(322,81,94),(323,82,92),(324,82,102),(325,82,103),(326,83,91),(327,83,92);
/*!40000 ALTER TABLE `mon_an_nguyen_lieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nguyen_lieu`
--

DROP TABLE IF EXISTS `nguyen_lieu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `nguyen_lieu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=165 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nguyen_lieu`
--

LOCK TABLES `nguyen_lieu` WRITE;
/*!40000 ALTER TABLE `nguyen_lieu` DISABLE KEYS */;
INSERT INTO `nguyen_lieu` VALUES (1,'Bánh phở tươi'),(2,'rau thơm'),(3,'nước dùng'),(4,'thịt bò'),(5,'Bò'),(6,'hành tây'),(7,'cà rốt'),(8,'su hào'),(9,'dưa chuột'),(10,'ớt chuông'),(11,'tiêu đen'),(12,'rau củ'),(13,'nấm'),(14,'phô mai Cheddar'),(15,'bột tỏi nước cốt chanh'),(16,'ớt'),(17,'Bơ lac'),(18,'mứt'),(19,'trứng'),(20,'bánh mỳ'),(21,'Cháo'),(22,'cá lóc'),(23,'hành'),(24,'tôm hùm'),(25,'rau dăm'),(26,'tiêu'),(27,'Chân dê'),(28,'thuốc bắc'),(29,'bún'),(30,'Cua'),(31,'rau mùi'),(32,'Cà ri'),(33,'nước cốt dừa'),(34,'Cá bông mú'),(35,'ngao'),(36,'gừng'),(37,'cần tây'),(38,'hành củ'),(39,'đinh hương'),(40,'Cá chép'),(41,'nước đường'),(42,'cơm trắng'),(43,'Cá diêu hồng'),(44,'chanh dây'),(45,'Cá hồi sống'),(46,'cơm'),(47,'me'),(48,'bánh hỏi'),(49,'Cá mòi'),(50,'bạc hà'),(51,'sả'),(52,'dừa'),(53,'mì'),(54,'cá'),(55,'gà'),(56,'hạt sen'),(57,'lá rong biển'),(58,'thịt lơn'),(59,'Lạp xưởng'),(60,'đậu Hà Lan'),(61,'thịt'),(62,'rau bina'),(63,'giá'),(64,'Dê núi'),(65,'lá sả'),(66,'Gà luộc'),(67,'Gà tiệm hạt sen'),(68,'chà bông(ruốc)'),(69,'xôi nếp'),(70,'dưa leo'),(71,'cà chưa'),(72,'gạo nếp'),(73,'hoàng kỳ'),(74,'táo tàu'),(75,'sâm'),(76,'lá sen'),(77,'bánh bao'),(78,'trứng gà'),(79,'xà lách'),(80,'xôi'),(81,'rúng non'),(82,'gia vị'),(83,'đậu phộng'),(84,'dầu mè'),(85,'nước tương'),(86,'Gân bò'),(87,'lạc'),(88,'Heo sữa'),(89,'Hải sản(tôm'),(90,'cá)'),(91,'Hải sản'),(92,'rau diếp'),(93,'Kim chi'),(94,'tỏi'),(95,'Lợn sữa'),(96,'Miến'),(97,'nước kim chi'),(98,'củ cải'),(99,'Ngũ cốc'),(100,'bí đỏ '),(101,'kem'),(102,'thịt heo'),(103,'flyfood'),(104,'khế chua'),(105,'Sò điệp'),(106,'Sườn bò'),(107,'Sườn heo'),(108,'Sứa'),(109,'Thị ba chỉ'),(110,'hành khô'),(111,'Thị heo'),(112,'Thịt ba chỉ'),(113,'bột bắp'),(114,'đường tiêu'),(115,'nước ép tỏi'),(116,'ngô'),(117,'nước chanh'),(118,'muối biển'),(119,'nước dừa'),(120,'nghệ'),(121,'xì dầu'),(122,'lá vừng'),(123,'Thịt dê'),(124,'tiêu xay'),(125,'tương ớt'),(126,'ngũ vị hương'),(127,'sa tế'),(128,'bột nêm'),(129,'tía tô'),(130,'húng'),(131,'quế'),(132,'khế'),(133,'chuối xanh'),(134,'tương bần'),(135,'sung muối'),(136,'chuối'),(137,'Thịt gà'),(138,'nấm đông cô'),(139,'phomai'),(140,'ớt cay'),(141,'hành lá'),(142,'măng'),(143,'muối'),(144,'Thịt luộc'),(145,'bánh tráng'),(146,'Tiết tôm'),(147,'thịt tôm hùm'),(148,'bột mì'),(149,'Tôm càng'),(150,'phomai Mozzarella'),(151,'rau củ quả'),(152,'Tôm khô'),(153,'đườg mía'),(154,'xôi hấp'),(155,'giá đỗ'),(156,'đu đủ'),(157,'Tôm'),(158,'cà tím'),(159,'lá chanh'),(160,'Vi cá'),(161,'Vịt'),(162,'sốt hoisin'),(163,'Đậu phụ'),(164,'sò');
/*!40000 ALTER TABLE `nguyen_lieu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quoc_gia`
--

DROP TABLE IF EXISTS `quoc_gia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `quoc_gia` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quoc_gia`
--

LOCK TABLES `quoc_gia` WRITE;
/*!40000 ALTER TABLE `quoc_gia` DISABLE KEYS */;
INSERT INTO `quoc_gia` VALUES (1,'Anh'),(2,'Bắc Kinh – Trung Quốc'),(3,'Hàn quốc'),(4,'Hồng Kông'),(5,'Indonesia'),(6,'Malaysia'),(7,'Mỹ'),(8,'Nhật Bản'),(9,'Pháp'),(10,'Philippine'),(11,'Singapore'),(12,'Thái Lan'),(13,'Thượng hải'),(14,'Trung Quốc'),(15,'Việt Nam');
/*!40000 ALTER TABLE `quoc_gia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `the_loai`
--

DROP TABLE IF EXISTS `the_loai`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `the_loai` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ten` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `the_loai`
--

LOCK TABLES `the_loai` WRITE;
/*!40000 ALTER TABLE `the_loai` DISABLE KEYS */;
INSERT INTO `the_loai` VALUES (1,'Bánh mì'),(2,'Bò'),(3,'Cua'),(4,'Cà ri'),(5,'Cá'),(6,'Cơm'),(7,'Gà'),(8,'Gỏi'),(9,'Hầm'),(10,'Khai vị'),(11,'Kimchi'),(12,'Lợn'),(13,'Miến'),(14,'Mì'),(15,'Phở'),(16,'Pizza'),(17,'Sushi'),(18,'Súp'),(19,'Sườn'),(20,'Thịt dê'),(21,'Thịt heo'),(22,'Tôm'),(23,'Vịt'),(24,NULL);
/*!40000 ALTER TABLE `the_loai` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-04 22:09:51
