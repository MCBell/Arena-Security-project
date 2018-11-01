-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 50.62.209.8:3306
-- Generation Time: Nov 29, 2017 at 12:01 PM
-- Server version: 5.5.43-37.2-log
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `arenadatabase`
--

-- --------------------------------------------------------

--
-- Table structure for table `adstorage`
--

CREATE TABLE `adstorage` (
  `adID` int(11) NOT NULL,
  `roleToSee` varchar(200) NOT NULL,
  `topBannerName` varchar(200) DEFAULT 'default1.jpg',
  `bottomBannerName` varchar(200) DEFAULT 'default1.jpg',
  `leftBannerName` varchar(200) DEFAULT 'default1.jpg',
  `rightBannerName` varchar(200) DEFAULT 'default1.jpg',
  `bgBannerName` varchar(200) DEFAULT 'domina1.jpg'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adstorage`
--

INSERT INTO `adstorage` (`adID`, `roleToSee`, `topBannerName`, `bottomBannerName`, `leftBannerName`, `rightBannerName`, `bgBannerName`) VALUES
(1, 'Player', 'testAdOne.jpg', 'testAdOne.jpg', 'testAdOne.jpg', 'testAdOne.jpg', 'domina1.jpg'),
(2, 'LeagueOwner', '6359619425121062721069548878_Patrick-Star-Meme-I-Have-3-Dollars-01-1.jpg', 'testAdOne.jpg', 'testAdOne.jpg', '6359619425121062721069548878_Patrick-Star-Meme-I-Have-3-Dollars-01-1.jpg', 'domina1.jpg'),
(3, 'Spectator', 'space_rainbow_by_sanlea-d3bh1fw.jpg', 'space_rainbow_by_sanlea-d3bh1fw.jpg', 'space_rainbow_by_sanlea-d3bh1fw.jpg', 'space_rainbow_by_sanlea-d3bh1fw.jpg', 'domina4.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `advertisment`
--

CREATE TABLE `advertisment` (
  `AdvertismentID` int(11) NOT NULL,
  `users_userID` int(10) NOT NULL,
  `AdvertismentName` varchar(100) NOT NULL,
  `image_blob` longblob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `advertisment`
--



-- --------------------------------------------------------

--
-- Table structure for table `advertismentscheme`
--

CREATE TABLE `advertismentscheme` (
  `AdvertismentSchemeID` int(11) NOT NULL,
  `AdSchemeName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `advertismentscheme`
--

INSERT INTO `advertismentscheme` (`AdvertismentSchemeID`, `AdSchemeName`) VALUES
(1, 'Top Banner'),
(2, 'Left Side Banner'),
(3, 'Right Side Banner'),
(4, 'Bottom Banner'),
(5, 'Background Banner');

-- --------------------------------------------------------

--
-- Table structure for table `arena`
--

CREATE TABLE `arena` (
  `ArenaID` int(11) NOT NULL,
  `ArenaName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `arena`
--

INSERT INTO `arena` (`ArenaID`, `ArenaName`) VALUES
(50001, 'Atlanta'),
(50003, 'New Orleans'),
(50006, 'New York'),
(50007, 'Seaside Cliffs');

-- --------------------------------------------------------

--
-- Table structure for table `arenamembers`
--

CREATE TABLE `arenamembers` (
  `arena_ArenaID` int(11) NOT NULL,
  `users_userID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `expertratingformula`
--

CREATE TABLE `expertratingformula` (
  `ExpertRatingFormulaID` int(11) NOT NULL,
  `ExpertRatingFormulaFormula` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `expertratingformula`
--

INSERT INTO `expertratingformula` (`ExpertRatingFormulaID`, `ExpertRatingFormulaFormula`) VALUES
(990001, 'Something Goes Here'),
(990002, 'Something Else Goes Here'),
(990003, 'Something Else');

-- --------------------------------------------------------

--
-- Table structure for table `game`
--

CREATE TABLE `game` (
  `GameID` int(11) NOT NULL,
  `GameName` varchar(45) DEFAULT NULL,
  `GameDescription` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `game`
--

INSERT INTO `game` (`GameID`, `GameName`, `GameDescription`) VALUES
(11001, 'Pokemon', 'Trading Card Game'),
(11002, 'Magic', 'Trading Card Game'),
(11004, 'Soccer', 'American Football'),
(11014, 'Test', 'Test Desc'),
(11016, 'TestName1', 'TestDesc1'),
(11017, 'TicTacToe', 'X''s & O''s '),
(11018, 'Halo', 'First Person Shooter'),
(11019, 'Arena', 'The winner will ascend to divinity');

-- --------------------------------------------------------

--
-- Table structure for table `league`
--

CREATE TABLE `league` (
  `LeagueID` int(11) NOT NULL,
  `LeagueName` varchar(45) DEFAULT NULL,
  `leagueDesc` varchar(45) DEFAULT NULL,
  `ExpertRatingFormula_ExpertRatingFormulaID` int(11) NOT NULL,
  `users_userID_LeagueOwner` int(10) NOT NULL,
  `arena_ArenaID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `league`
--

INSERT INTO `league` (`LeagueID`, `LeagueName`, `leagueDesc`, `ExpertRatingFormula_ExpertRatingFormulaID`, `users_userID_LeagueOwner`, `arena_ArenaID`) VALUES
(800001, 'Example League Name', NULL, 990001, 900000001, 50001),
(800002, 'Example League Test Name', NULL, 990001, 900000005, 50001),
(800003, 'League Test Name Test1', NULL, 990001, 900000001, 50001),
(800004, 'asdfqweas', 'asdf aczeaf asdf', 990001, 900000005, 50001),
(800005, 'madkemc', 'asdf acze', 990001, 900000005, 50001),
(800006, 'Test 5', 'Now not jibberish', 990001, 900000005, 50001),
(800008, 'League Prism', 'Test League Adam One', 990001, 900000018, 50001),
(800009, 'Tims League One', 'Tims First League!', 990001, 900000019, 50001),
(800010, 'League Bob', 'League o Bob', 990001, 900000001, 50001),
(800011, 'Rob''s League', 'Anything I want we do.', 990001, 900000005, 50001),
(800012, 'Test Campus', 'Hello World', 990002, 900000005, 50001),
(800014, 'League Class ABC', 'Class League Stuff', 990001, 900000019, 50001);

-- --------------------------------------------------------

--
-- Table structure for table `leaguemembers`
--

CREATE TABLE `leaguemembers` (
  `League_LeagueID` int(11) NOT NULL,
  `MembershipStatusCode_MembershipStatusCodeID` int(11) NOT NULL,
  `users_userID` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `leaguemembers`
--

INSERT INTO `leaguemembers` (`League_LeagueID`, `MembershipStatusCode_MembershipStatusCodeID`, `users_userID`) VALUES
(800008, 0, 900000024),
(800010, 0, 900000020),
(800001, 1, 900000003),
(800003, 1, 900000003),
(800004, 1, 900000003),
(800009, 1, 900000025),
(800012, 1, 900000024);

-- --------------------------------------------------------

--
-- Table structure for table `match`
--

CREATE TABLE `match` (
  `MatchID` int(11) NOT NULL,
  `OutcomeWin_UserID` varchar(45) DEFAULT NULL,
  `OutcomeLoss_UserID` varchar(45) DEFAULT NULL,
  `MatchStatus_MatchStatusID` int(11) NOT NULL,
  `Game_GameID` int(11) NOT NULL,
  `Tournament_TournamentID` int(11) NOT NULL,
  `matchDate` datetime DEFAULT NULL,
  `teams_TeamID2` int(11) NOT NULL,
  `teams_TeamID1` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `match`
--

INSERT INTO `match` (`MatchID`, `OutcomeWin_UserID`, `OutcomeLoss_UserID`, `MatchStatus_MatchStatusID`, `Game_GameID`, `Tournament_TournamentID`, `matchDate`, `teams_TeamID2`, `teams_TeamID1`) VALUES
(1, NULL, NULL, 0, 11001, 1000007, '2017-11-21 14:48:00', 9, 2),
(2, NULL, NULL, 0, 11004, 1000007, '2017-11-16 14:49:00', 9, 2),
(3, NULL, NULL, 0, 11001, 1000008, '2017-11-16 14:50:00', 2, 9),
(4, NULL, NULL, 0, 11001, 1000006, '2017-11-18 17:55:00', 8, 2),
(5, NULL, NULL, 0, 11001, 1000006, '2017-11-08 16:57:00', 2, 9);

-- --------------------------------------------------------

--
-- Table structure for table `matches`
--

CREATE TABLE `matches` (
  `MatchID` int(11) NOT NULL,
  `OutcomeWin_UserID` varchar(45) DEFAULT NULL,
  `OutcomeLoss_UserID` varchar(45) DEFAULT NULL,
  `MatchStatus_MatchStatusID` int(11) NOT NULL,
  `Game_GameID` int(11) NOT NULL,
  `Tournament_TournamentID` int(11) NOT NULL,
  `matchDate` datetime DEFAULT NULL,
  `teams_TeamID2` int(11) NOT NULL,
  `teams_TeamID1` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `matches`
--

INSERT INTO `matches` (`MatchID`, `OutcomeWin_UserID`, `OutcomeLoss_UserID`, `MatchStatus_MatchStatusID`, `Game_GameID`, `Tournament_TournamentID`, `matchDate`, `teams_TeamID2`, `teams_TeamID1`) VALUES
(1, NULL, NULL, 0, 11001, 1000007, '2017-11-21 14:48:00', 9, 2),
(2, NULL, NULL, 0, 11004, 1000007, '2017-11-16 14:49:00', 9, 2),
(3, NULL, NULL, 0, 11001, 1000008, '2017-11-16 14:50:00', 2, 9),
(4, '2', '8', 2, 11001, 1000006, '2017-11-18 17:55:00', 8, 2),
(5, '9', '2', 2, 11001, 1000006, '2017-11-08 16:57:00', 2, 9),
(6, NULL, NULL, 1, 11004, 1000005, '2017-11-26 21:41:00', 8, 2),
(7, '2', '8', 2, 11004, 1000005, '2017-11-26 21:45:00', 8, 2),
(8, '9', '2', 2, 11004, 1000005, '2017-11-28 19:54:00', 9, 2),
(9, NULL, NULL, 0, 11014, 1000013, '2017-11-28 20:04:00', 9, 2),
(10, '2', '9', 2, 11017, 1000005, '2017-11-28 20:06:00', 9, 2),
(11, '9', '8', 2, 11016, 1000006, '2017-11-28 20:29:00', 9, 8);

-- --------------------------------------------------------

--
-- Table structure for table `matchstatus`
--

CREATE TABLE `matchstatus` (
  `MatchStatusID` int(11) NOT NULL,
  `MatchStatusName` varchar(45) DEFAULT NULL,
  `MatchStatusDesc` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `matchstatus`
--

INSERT INTO `matchstatus` (`MatchStatusID`, `MatchStatusName`, `MatchStatusDesc`) VALUES
(0, 'Pending', 'Pending Match'),
(1, 'Active', 'Active Match'),
(2, 'Complete', 'Complete Match'),
(3, 'Cancelled', 'Cancelled Match');

-- --------------------------------------------------------

--
-- Table structure for table `membershipstatuscode`
--

CREATE TABLE `membershipstatuscode` (
  `MembershipStatusCodeID` int(11) NOT NULL,
  `MembershipStatusCodeName` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `membershipstatuscode`
--

INSERT INTO `membershipstatuscode` (`MembershipStatusCodeID`, `MembershipStatusCodeName`) VALUES
(0, 'pending'),
(1, 'member'),
(2, 'banned');

-- --------------------------------------------------------

--
-- Table structure for table `pending`
--

CREATE TABLE `pending` (
  `appID` int(11) NOT NULL,
  `appUserID` int(10) NOT NULL,
  `appCurrentRole` int(11) NOT NULL,
  `desired_RoleID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `playerlose`
--

CREATE TABLE `playerlose` (
  `match_MatchID` int(11) NOT NULL,
  `users_userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `playerlose`
--

INSERT INTO `playerlose` (`match_MatchID`, `users_userID`) VALUES
(7, 900000024),
(8, 900000020),
(8, 900000025),
(11, 900000024);

-- --------------------------------------------------------

--
-- Table structure for table `playertournywin`
--

CREATE TABLE `playertournywin` (
  `Tournament_TournamentID` int(11) NOT NULL,
  `users_userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `playerwin`
--

CREATE TABLE `playerwin` (
  `match_MatchID` int(11) NOT NULL,
  `users_userID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `playerwin`
--

INSERT INTO `playerwin` (`match_MatchID`, `users_userID`) VALUES
(6, 900000020),
(6, 900000025),
(7, 900000020),
(7, 900000025),
(10, 900000020),
(10, 900000025);

-- --------------------------------------------------------

--
-- Table structure for table `scores`
--

CREATE TABLE `scores` (
  `ScoreID` int(11) NOT NULL,
  `match_MatchID` int(11) NOT NULL,
  `game_GameID` int(11) NOT NULL,
  `Team1_Score` varchar(45) DEFAULT NULL,
  `Team2_Score` varchar(45) DEFAULT NULL,
  `teams_TeamID2` int(11) NOT NULL,
  `teams_TeamID1` int(11) NOT NULL,
  `ScoreStatusTable_idScoreStatusTable` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `scores`
--

INSERT INTO `scores` (`ScoreID`, `match_MatchID`, `game_GameID`, `Team1_Score`, `Team2_Score`, `teams_TeamID2`, `teams_TeamID1`, `ScoreStatusTable_idScoreStatusTable`) VALUES
(11, 4, 11001, '4000', '4000', 2, 8, 2),
(12, 4, 11001, '3800', '3700', 2, 8, 2),
(13, 4, 11001, '3600', '3500', 2, 8, 2),
(14, 4, 11001, '3700', '3000', 2, 8, 2),
(15, 4, 11001, '8000', '0', 2, 8, 2),
(16, 5, 11001, '4000', '4000', 9, 2, 2),
(17, 5, 11001, '200', '0', 9, 2, 2),
(18, 8, 11004, '0', '1', 2, 9, 1),
(19, 8, 11004, '1', '1', 2, 9, 1),
(20, 8, 11004, '2', '1', 2, 9, 1),
(21, 8, 11004, '3', '1', 2, 9, 1),
(22, 10, 11017, '5', '4', 2, 9, 2),
(23, 11, 11016, '0', '1', 8, 9, 2),
(24, 11, 11016, '3', '4', 8, 9, 2);

-- --------------------------------------------------------

--
-- Table structure for table `scorestatustable`
--

CREATE TABLE `scorestatustable` (
  `idScoreStatusTable` int(11) NOT NULL,
  `ScoreStatusName` varchar(45) DEFAULT NULL,
  `ScoreStatusDesc` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `scorestatustable`
--

INSERT INTO `scorestatustable` (`idScoreStatusTable`, `ScoreStatusName`, `ScoreStatusDesc`) VALUES
(1, 'ongoing', 'Ongoing Scores'),
(2, 'pending', 'Approval Pending'),
(3, 'rejected', 'Rejected Scrores'),
(4, 'approved', 'Approved Final Scores'),
(5, 'cancelled', 'Cancelled Match Scores');

-- --------------------------------------------------------

--
-- Table structure for table `teams`
--

CREATE TABLE `teams` (
  `TeamID` int(11) NOT NULL,
  `TeamName` varchar(45) DEFAULT NULL,
  `users_userID` int(10) NOT NULL,
  `league_LeagueID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `teams`
--

INSERT INTO `teams` (`TeamID`, `TeamName`, `users_userID`, `league_LeagueID`) VALUES
(0, 'Not in a Team', 900000017, 800001),
(2, 'Team Rocket', 900000001, 800008),
(8, 'fist', 900000005, 800003),
(9, 'Team Class', 900000019, 800002);

-- --------------------------------------------------------

--
-- Table structure for table `teamspending`
--

CREATE TABLE `teamspending` (
  `loAppID` int(11) NOT NULL,
  `appUserID` int(11) DEFAULT NULL,
  `appUserName` varchar(45) DEFAULT NULL,
  `desired_teamName` varchar(45) DEFAULT NULL,
  `current_teamName` varchar(45) DEFAULT NULL,
  `desired_teamID` int(11) DEFAULT NULL,
  `leagueOwnerID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `tournament`
--

CREATE TABLE `tournament` (
  `TournamentID` int(11) NOT NULL,
  `TournamentName` varchar(45) DEFAULT NULL,
  `TournamentDescription` varchar(45) DEFAULT NULL,
  `League_LeagueID` int(11) NOT NULL,
  `TournamentStyleCode_TournamentStyleCodeID` int(11) NOT NULL,
  `tournamentDate` date DEFAULT NULL,
  `tournamentWinner_TeamID` varchar(45) DEFAULT NULL,
  `tournamentStatus` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tournament`
--

INSERT INTO `tournament` (`TournamentID`, `TournamentName`, `TournamentDescription`, `League_LeagueID`, `TournamentStyleCode_TournamentStyleCodeID`, `tournamentDate`, `tournamentWinner_TeamID`, `tournamentStatus`) VALUES
(1000002, 'Robert Cromer', 'Server', 800004, 40001, '2017-11-10', NULL, NULL),
(1000003, 'Testin Testin', 'Testerino', 800005, 40001, '2017-11-30', NULL, NULL),
(1000005, 'Bren', 'bren', 800005, 40003, '2017-11-24', NULL, NULL),
(1000006, 'Twilight', 'Sparkle', 800004, 40003, '2017-12-05', '2', NULL),
(1000007, 'Tournament of Bob', 'Bob ofc.', 800001, 40002, '2017-12-11', NULL, NULL),
(1000008, 'Test Tourn 4', 'test4', 800009, 40002, '2017-11-22', NULL, NULL),
(1000009, 'Thunder FootBall Tournament', 'FootBall Tournament', 800002, 40003, '2017-11-20', NULL, NULL),
(1000012, 'Campus Test', 'Test', 800012, 40001, '2017-11-23', NULL, NULL),
(1000013, 'Team Class', 'Class Team', 800014, 40002, '2017-11-17', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tournamentstylecode`
--

CREATE TABLE `tournamentstylecode` (
  `TournamentStyleCodeID` int(11) NOT NULL,
  `TournamentStyleCodeName` varchar(45) DEFAULT NULL,
  `TournamentStyleCodeDesc` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `tournamentstylecode`
--

INSERT INTO `tournamentstylecode` (`TournamentStyleCodeID`, `TournamentStyleCodeName`, `TournamentStyleCodeDesc`) VALUES
(40001, 'Single Elimination', 'Single Elimination'),
(40002, 'Double Elimination', 'Double Elimination'),
(40003, 'Round Robin', 'Round Robin');

-- --------------------------------------------------------

--
-- Table structure for table `userroletype`
--

CREATE TABLE `userroletype` (
  `userRoleTypeID` int(11) NOT NULL,
  `userRoleTypeName` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `userroletype`
--

INSERT INTO `userroletype` (`userRoleTypeID`, `userRoleTypeName`) VALUES
(0, 'Operator'),
(1, 'LeagueOwner'),
(2, 'Advertiser'),
(3, 'Player'),
(4, 'Spectator');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userID` int(10) NOT NULL,
  `userName` varchar(45) DEFAULT NULL,
  `userPassword` varchar(45) DEFAULT NULL,
  `userRoleID` int(11) NOT NULL DEFAULT '4',
  `userTeamID` int(11) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userID`, `userName`, `userPassword`, `userRoleID`, `userTeamID`) VALUES
(900000000, 'admin', 'password', 0, 0),
(900000001, 'LeagueOwner', 'LeagueOwnerPassword ', 1, 0),
(900000002, 'Advertiser', 'AvertiserPassword', 2, 0),
(900000003, 'Player', 'PlayerPassword', 3, 0),
(900000004, 'Rob', 'rob', 0, 0),
(900000005, 'James', 'james', 1, 0),
(900000007, 'bren', 'bren', 4, 0),
(900000008, 'Mike', 'mikey', 2, 0),
(900000010, 'phily', 'phil', 4, 0),
(900000012, 'sam', 'sammy', 4, 0),
(900000013, 'roboo', 'robby', 1, 0),
(900000014, 'philyd', 'philyd', 3, 0),
(900000016, 'tay', 'tay', 2, 0),
(900000017, 'bob', 'bob', 0, 0),
(900000018, 'Adam', 'bob', 1, 0),
(900000019, 'Tim', 'bob', 1, 0),
(900000020, 'Tina', 'bob', 3, 2),
(900000022, 'Dog', 'bob', 1, 0),
(900000023, 'a', 'p', 0, 0),
(900000024, 'MarkTest', 'Test', 3, 8),
(900000025, 'Jim', 'bob', 3, 2),
(900000026, 'bill', 'petty', 1, 0),
(900000027, 'sample', 'user', 1, 0),
(900000028, 'Class', 'bob', 0, 0),
(900000029, 'Joe', 'bob', 2, 0),
(900000030, 'csquared', 'kettlecorn', 0, 0),
(900000031, 'SpecTest', 'Test', 4, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adstorage`
--
ALTER TABLE `adstorage`
  ADD PRIMARY KEY (`adID`),
  ADD UNIQUE KEY `adID_UNIQUE` (`adID`),
  ADD UNIQUE KEY `roleToSee_UNIQUE` (`roleToSee`);

--
-- Indexes for table `advertisment`
--
ALTER TABLE `advertisment`
  ADD PRIMARY KEY (`AdvertismentID`,`users_userID`),
  ADD UNIQUE KEY `AdvertismentName_UNIQUE` (`AdvertismentName`);

--
-- Indexes for table `advertismentscheme`
--
ALTER TABLE `advertismentscheme`
  ADD PRIMARY KEY (`AdvertismentSchemeID`);

--
-- Indexes for table `arena`
--
ALTER TABLE `arena`
  ADD PRIMARY KEY (`ArenaID`);

--
-- Indexes for table `arenamembers`
--
ALTER TABLE `arenamembers`
  ADD PRIMARY KEY (`arena_ArenaID`,`users_userID`),
  ADD KEY `fk_arenamembers_arena1_idx` (`arena_ArenaID`),
  ADD KEY `fk_arenamembers_users1` (`users_userID`);

--
-- Indexes for table `expertratingformula`
--
ALTER TABLE `expertratingformula`
  ADD PRIMARY KEY (`ExpertRatingFormulaID`);

--
-- Indexes for table `game`
--
ALTER TABLE `game`
  ADD PRIMARY KEY (`GameID`);

--
-- Indexes for table `league`
--
ALTER TABLE `league`
  ADD PRIMARY KEY (`LeagueID`,`ExpertRatingFormula_ExpertRatingFormulaID`,`users_userID_LeagueOwner`,`arena_ArenaID`),
  ADD KEY `fk_League_ExpertRatingFormula1_idx` (`ExpertRatingFormula_ExpertRatingFormulaID`),
  ADD KEY `fk_league_arena1_idx` (`arena_ArenaID`),
  ADD KEY `fk_league_users1_idx` (`users_userID_LeagueOwner`);

--
-- Indexes for table `leaguemembers`
--
ALTER TABLE `leaguemembers`
  ADD PRIMARY KEY (`League_LeagueID`,`MembershipStatusCode_MembershipStatusCodeID`,`users_userID`),
  ADD KEY `fk_LeagueMembers_MembershipStatusCode1_idx` (`MembershipStatusCode_MembershipStatusCodeID`),
  ADD KEY `fk_leaguemembers_users1_idx` (`users_userID`);

--
-- Indexes for table `match`
--
ALTER TABLE `match`
  ADD PRIMARY KEY (`MatchID`,`MatchStatus_MatchStatusID`,`Game_GameID`,`Tournament_TournamentID`,`teams_TeamID2`,`teams_TeamID1`),
  ADD UNIQUE KEY `MatchID_UNIQUE` (`MatchID`),
  ADD KEY `fk_Match_Tournament1_idx` (`Tournament_TournamentID`);

--
-- Indexes for table `matches`
--
ALTER TABLE `matches`
  ADD PRIMARY KEY (`MatchID`,`MatchStatus_MatchStatusID`,`Game_GameID`,`Tournament_TournamentID`,`teams_TeamID2`,`teams_TeamID1`),
  ADD UNIQUE KEY `MatchID_UNIQUE` (`MatchID`),
  ADD KEY `fk_Match_MatchStatus1_idx` (`MatchStatus_MatchStatusID`),
  ADD KEY `fk_Match_Game_idx` (`Game_GameID`),
  ADD KEY `fk_Match_Tournament1_idx` (`Tournament_TournamentID`),
  ADD KEY `fk_match_teams1_idx` (`teams_TeamID2`),
  ADD KEY `fk_match_teams2_idx` (`teams_TeamID1`);

--
-- Indexes for table `matchstatus`
--
ALTER TABLE `matchstatus`
  ADD PRIMARY KEY (`MatchStatusID`);

--
-- Indexes for table `membershipstatuscode`
--
ALTER TABLE `membershipstatuscode`
  ADD PRIMARY KEY (`MembershipStatusCodeID`),
  ADD UNIQUE KEY `MembershipStatusCodeID_UNIQUE` (`MembershipStatusCodeID`);

--
-- Indexes for table `pending`
--
ALTER TABLE `pending`
  ADD PRIMARY KEY (`appID`,`appUserID`,`appCurrentRole`,`desired_RoleID`),
  ADD KEY `fk_pending_users1_idx` (`appUserID`,`appCurrentRole`),
  ADD KEY `fk_pending_userroletype1_idx` (`desired_RoleID`);

--
-- Indexes for table `playerlose`
--
ALTER TABLE `playerlose`
  ADD KEY `MatchID` (`match_MatchID`),
  ADD KEY `userID` (`users_userID`);

--
-- Indexes for table `playertournywin`
--
ALTER TABLE `playertournywin`
  ADD KEY `TournamentID` (`Tournament_TournamentID`),
  ADD KEY `userID` (`users_userID`);

--
-- Indexes for table `playerwin`
--
ALTER TABLE `playerwin`
  ADD KEY `MatchID` (`match_MatchID`),
  ADD KEY `userID` (`users_userID`);

--
-- Indexes for table `scores`
--
ALTER TABLE `scores`
  ADD PRIMARY KEY (`ScoreID`,`match_MatchID`,`game_GameID`,`teams_TeamID2`,`teams_TeamID1`,`ScoreStatusTable_idScoreStatusTable`),
  ADD UNIQUE KEY `ScoreID_UNIQUE` (`ScoreID`),
  ADD KEY `fk_MatchScores_game1_idx` (`game_GameID`),
  ADD KEY `fk_MatchScores_match1` (`match_MatchID`),
  ADD KEY `fk_scores_teams1_idx` (`teams_TeamID2`),
  ADD KEY `fk_scores_teams2_idx` (`teams_TeamID1`),
  ADD KEY `fk_scores_ScoreStatusTable1_idx` (`ScoreStatusTable_idScoreStatusTable`);

--
-- Indexes for table `scorestatustable`
--
ALTER TABLE `scorestatustable`
  ADD PRIMARY KEY (`idScoreStatusTable`),
  ADD UNIQUE KEY `idScoreStatusTable_UNIQUE` (`idScoreStatusTable`);

--
-- Indexes for table `teams`
--
ALTER TABLE `teams`
  ADD PRIMARY KEY (`TeamID`,`users_userID`,`league_LeagueID`),
  ADD KEY `fk_teams_users1_idx` (`users_userID`),
  ADD KEY `fk_teams_league1_idx` (`league_LeagueID`);

--
-- Indexes for table `teamspending`
--
ALTER TABLE `teamspending`
  ADD PRIMARY KEY (`loAppID`);

--
-- Indexes for table `tournament`
--
ALTER TABLE `tournament`
  ADD PRIMARY KEY (`TournamentID`,`League_LeagueID`,`TournamentStyleCode_TournamentStyleCodeID`),
  ADD UNIQUE KEY `TournamentID_UNIQUE` (`TournamentID`),
  ADD KEY `fk_Tournament_League1_idx` (`League_LeagueID`),
  ADD KEY `fk_Tournament_TournamentStyleCode1_idx` (`TournamentStyleCode_TournamentStyleCodeID`);

--
-- Indexes for table `tournamentstylecode`
--
ALTER TABLE `tournamentstylecode`
  ADD PRIMARY KEY (`TournamentStyleCodeID`);

--
-- Indexes for table `userroletype`
--
ALTER TABLE `userroletype`
  ADD PRIMARY KEY (`userRoleTypeID`,`userRoleTypeName`),
  ADD UNIQUE KEY `userRoleTypeID_UNIQUE` (`userRoleTypeID`),
  ADD UNIQUE KEY `userRoleTypeName_UNIQUE` (`userRoleTypeName`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userID`,`userRoleID`),
  ADD UNIQUE KEY `userID_UNIQUE` (`userID`),
  ADD UNIQUE KEY `userName_UNIQUE` (`userName`),
  ADD KEY `fk_users_userroletype1_idx` (`userRoleID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `adstorage`
--
ALTER TABLE `adstorage`
  MODIFY `adID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `advertisment`
--
ALTER TABLE `advertisment`
  MODIFY `AdvertismentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=47;
--
-- AUTO_INCREMENT for table `advertismentscheme`
--
ALTER TABLE `advertismentscheme`
  MODIFY `AdvertismentSchemeID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `arena`
--
ALTER TABLE `arena`
  MODIFY `ArenaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=50008;
--
-- AUTO_INCREMENT for table `expertratingformula`
--
ALTER TABLE `expertratingformula`
  MODIFY `ExpertRatingFormulaID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=990004;
--
-- AUTO_INCREMENT for table `game`
--
ALTER TABLE `game`
  MODIFY `GameID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11020;
--
-- AUTO_INCREMENT for table `league`
--
ALTER TABLE `league`
  MODIFY `LeagueID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=800015;
--
-- AUTO_INCREMENT for table `leaguemembers`
--
ALTER TABLE `leaguemembers`
  MODIFY `League_LeagueID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=800013;
--
-- AUTO_INCREMENT for table `match`
--
ALTER TABLE `match`
  MODIFY `MatchID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `matches`
--
ALTER TABLE `matches`
  MODIFY `MatchID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `pending`
--
ALTER TABLE `pending`
  MODIFY `appID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `scores`
--
ALTER TABLE `scores`
  MODIFY `ScoreID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT for table `scorestatustable`
--
ALTER TABLE `scorestatustable`
  MODIFY `idScoreStatusTable` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT for table `teams`
--
ALTER TABLE `teams`
  MODIFY `TeamID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT for table `teamspending`
--
ALTER TABLE `teamspending`
  MODIFY `loAppID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `tournament`
--
ALTER TABLE `tournament`
  MODIFY `TournamentID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1000014;
--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userID` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=900000032;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `arenamembers`
--
ALTER TABLE `arenamembers`
  ADD CONSTRAINT `fk_arenamembers_arena1` FOREIGN KEY (`arena_ArenaID`) REFERENCES `arena` (`ArenaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_arenamembers_users1` FOREIGN KEY (`users_userID`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `league`
--
ALTER TABLE `league`
  ADD CONSTRAINT `fk_League_ExpertRatingFormula1` FOREIGN KEY (`ExpertRatingFormula_ExpertRatingFormulaID`) REFERENCES `expertratingformula` (`ExpertRatingFormulaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_league_arena1` FOREIGN KEY (`arena_ArenaID`) REFERENCES `arena` (`ArenaID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_league_users1` FOREIGN KEY (`users_userID_LeagueOwner`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `leaguemembers`
--
ALTER TABLE `leaguemembers`
  ADD CONSTRAINT `fk_LeagueMembers_League1` FOREIGN KEY (`League_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_LeagueMembers_MembershipStatusCode1` FOREIGN KEY (`MembershipStatusCode_MembershipStatusCodeID`) REFERENCES `membershipstatuscode` (`MembershipStatusCodeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_leaguemembers_users1` FOREIGN KEY (`users_userID`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `matches`
--
ALTER TABLE `matches`
  ADD CONSTRAINT `fk_Match_Game` FOREIGN KEY (`Game_GameID`) REFERENCES `game` (`GameID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Match_MatchStatus1` FOREIGN KEY (`MatchStatus_MatchStatusID`) REFERENCES `matchstatus` (`MatchStatusID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_match_teams1` FOREIGN KEY (`teams_TeamID2`) REFERENCES `teams` (`TeamID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_match_teams2` FOREIGN KEY (`teams_TeamID1`) REFERENCES `teams` (`TeamID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `pending`
--
ALTER TABLE `pending`
  ADD CONSTRAINT `fk_pending_userroletype1` FOREIGN KEY (`desired_RoleID`) REFERENCES `userroletype` (`userRoleTypeID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_pending_users1` FOREIGN KEY (`appUserID`,`appCurrentRole`) REFERENCES `users` (`userID`, `userRoleID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `scores`
--
ALTER TABLE `scores`
  ADD CONSTRAINT `fk_MatchScores_game1` FOREIGN KEY (`game_GameID`) REFERENCES `game` (`GameID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_MatchScores_match1` FOREIGN KEY (`match_MatchID`) REFERENCES `matches` (`MatchID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_scores_ScoreStatusTable1` FOREIGN KEY (`ScoreStatusTable_idScoreStatusTable`) REFERENCES `scorestatustable` (`idScoreStatusTable`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_scores_teams1` FOREIGN KEY (`teams_TeamID2`) REFERENCES `teams` (`TeamID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_scores_teams2` FOREIGN KEY (`teams_TeamID1`) REFERENCES `teams` (`TeamID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `teams`
--
ALTER TABLE `teams`
  ADD CONSTRAINT `fk_teams_league1` FOREIGN KEY (`league_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_teams_users1` FOREIGN KEY (`users_userID`) REFERENCES `users` (`userID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tournament`
--
ALTER TABLE `tournament`
  ADD CONSTRAINT `fk_Tournament_League1` FOREIGN KEY (`League_LeagueID`) REFERENCES `league` (`LeagueID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_Tournament_TournamentStyleCode1` FOREIGN KEY (`TournamentStyleCode_TournamentStyleCodeID`) REFERENCES `tournamentstylecode` (`TournamentStyleCodeID`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
