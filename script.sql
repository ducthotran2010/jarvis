USE [master]
GO
/****** Object:  Database [avengers]    Script Date: 15/07/2018 4:23:09 PM ******/
CREATE DATABASE [avengers]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'avengers', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.KIEMHH\MSSQL\DATA\avengers.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'avengers_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.KIEMHH\MSSQL\DATA\avengers_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [avengers] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [avengers].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [avengers] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [avengers] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [avengers] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [avengers] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [avengers] SET ARITHABORT OFF 
GO
ALTER DATABASE [avengers] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [avengers] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [avengers] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [avengers] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [avengers] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [avengers] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [avengers] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [avengers] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [avengers] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [avengers] SET  DISABLE_BROKER 
GO
ALTER DATABASE [avengers] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [avengers] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [avengers] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [avengers] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [avengers] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [avengers] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [avengers] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [avengers] SET RECOVERY FULL 
GO
ALTER DATABASE [avengers] SET  MULTI_USER 
GO
ALTER DATABASE [avengers] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [avengers] SET DB_CHAINING OFF 
GO
ALTER DATABASE [avengers] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [avengers] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [avengers] SET DELAYED_DURABILITY = DISABLED 
GO
USE [avengers]
GO
/****** Object:  Table [dbo].[Equipment]    Script Date: 15/07/2018 4:23:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Equipment](
	[code] [varchar](20) NOT NULL,
	[username] [varchar](20) NOT NULL,
	[name] [varchar](50) NOT NULL,
	[type] [varchar](20) NOT NULL,
	[description] [varchar](500) NULL,
	[urlImage] [varchar](250) NULL,
	[isRemoved] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Mission]    Script Date: 15/07/2018 4:23:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Mission](
	[id] [varchar](20) NOT NULL,
	[name] [varchar](20) NOT NULL,
	[status] [varchar](20) NOT NULL,
	[dateStart] [date] NOT NULL,
	[dateEnd] [date] NULL,
	[description] [varchar](500) NULL,
	[urlImage] [varchar](250) NULL,
	[isRemoved] [int] NOT NULL,
 CONSTRAINT [PK_Mission] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[MissionDetail]    Script Date: 15/07/2018 4:23:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[MissionDetail](
	[id] [int] IDENTITY(0,1) NOT NULL,
	[username] [varchar](20) NOT NULL,
	[missionID] [varchar](20) NOT NULL,
	[isQuitted] [int] NOT NULL,
 CONSTRAINT [PK_MissionDetail] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[User]    Script Date: 15/07/2018 4:23:09 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[User](
	[username] [varchar](20) NOT NULL,
	[password] [varchar](20) NOT NULL,
	[fullname] [varchar](50) NOT NULL,
	[role] [varchar](20) NOT NULL,
	[abilities] [varchar](250) NULL,
	[powers] [varchar](250) NULL,
	[height] [varchar](250) NULL,
	[weight] [varchar](250) NULL,
	[dateJoined] [date] NULL,
	[urlAvatar] [varchar](250) NULL,
	[isDeactive] [int] NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Equipment] ([code], [username], [name], [type], [description], [urlImage], [isRemoved]) VALUES (N'Armor3', N'ducthotran2010', N'Armor Level 3', N'Suit', N'PUBG Body armor will last until fully destroyed by gunfire or other types of damage and will block the full damage even if it has only 1 point of armor left. Level 3 is the Best Body Armor currently available.
', N'src/img/[Equipment]Armor3.jpg', 0)
INSERT [dbo].[Equipment] ([code], [username], [name], [type], [description], [urlImage], [isRemoved]) VALUES (N'E001', N'tonytony', N'Mark 50', N'Suit', N'The Mark 50 is Tony Stark''s fiftieth Iron Man suit. It was built after the Mark 47. The Information about Mark 48 and 49 is still officially unconfirmed, however there is strong speculation that the mark 48 is the Protoype for Mark 50 while Mark 49 is Hulkbuster Mark 2. Kevin Feige confirmed that this armor is named as the Mark 50.

', N'src/img/[Equipment]E001.png', 0)
INSERT [dbo].[Equipment] ([code], [username], [name], [type], [description], [urlImage], [isRemoved]) VALUES (N'head3', N'ducthotran2010', N'Spetsnaz Helmet Lv.3', N'Suit', N'This armor type is important for reducing your chances of getting Headshot, which will instantly kill you. Level 3 is the Best Head Armor currently available.', N'src/img/[Equipment]head3.jpg', 0)
INSERT [dbo].[Equipment] ([code], [username], [name], [type], [description], [urlImage], [isRemoved]) VALUES (N'MARK46', N'tonytony', N'Mark 46', N'Suit', N'The Mark 46 (Mark XLVI) is the forty-sixth Iron Man Armor created by Tony Stark. This armor was created sometime after the events of Avengers: Age of Ultron.', N'src/img/[Equipment]MARK46.png', 0)
INSERT [dbo].[Equipment] ([code], [username], [name], [type], [description], [urlImage], [isRemoved]) VALUES (N'MARKV', N'tonytony', N'Mark V', N'Suit', N'The Mark V (Mark 5), also known by its names as the "Football" and Suitcase Armor, is an Emergency Suit, and was the fifth Iron Man Armor designed and created by Tony Stark. It is the first armor to feature a new portable system that can fold itself into a briefcase and be deployed for use in civilian areas.[1]', N'src/img/[Equipment]MARKV.png', 0)
INSERT [dbo].[Equipment] ([code], [username], [name], [type], [description], [urlImage], [isRemoved]) VALUES (N'SMG', N'ducthotran2010', N'SMG', N'Weapon', N'We can''t sing the praises of the Vector enough. This thing has an absolutely insane fire-rate that''s capable of tearing through an enemy in seconds. It''s pretty easy to control the recoil when holding down the trigger as well. Even the iron sights are forgiving!', N'src/img/[Equipment]SMG.jpg', 0)
INSERT [dbo].[Mission] ([id], [name], [status], [dateStart], [dateEnd], [description], [urlImage], [isRemoved]) VALUES (N'MS000', N'Create to remove', N'Base on real time', CAST(N'2018-07-17' AS Date), NULL, N'Tony had just bought this JARVIS WEB. He test if this WEB works.', NULL, 1)
INSERT [dbo].[Mission] ([id], [name], [status], [dateStart], [dateEnd], [description], [urlImage], [isRemoved]) VALUES (N'MS001', N'Advertise JARVIS WEB', N'Base on real time', CAST(N'2018-07-19' AS Date), NULL, N'Advertise JARVIS WEB to every avenger.
The more people join JARVIS WEB, the more avengers strong.', N'src/img/[Mission]MS001.jpg', 0)
INSERT [dbo].[Mission] ([id], [name], [status], [dateStart], [dateEnd], [description], [urlImage], [isRemoved]) VALUES (N'MS002', N'Beat Thanos', N'Failed', CAST(N'2018-07-15' AS Date), CAST(N'2018-07-16' AS Date), N'KILL HIM', N'src/img/[Mission]MS002.jpg', 0)
INSERT [dbo].[Mission] ([id], [name], [status], [dateStart], [dateEnd], [description], [urlImage], [isRemoved]) VALUES (N'MS003', N'Kill terrorists', N'Cancelled', CAST(N'2018-07-20' AS Date), NULL, N'Mission cancelled.
Polices have killed terrorists before the avengers joined.', N'src/img/[Mission]MS003.jpg', 0)
INSERT [dbo].[Mission] ([id], [name], [status], [dateStart], [dateEnd], [description], [urlImage], [isRemoved]) VALUES (N'MS004', N'Authentic avenger', N'Base on real time', CAST(N'2018-07-19' AS Date), NULL, N'Many people know about this JARVIS WEB. They registration to be an avenger, we need to authentic them to check if they are a real avenger.', NULL, 0)
INSERT [dbo].[Mission] ([id], [name], [status], [dateStart], [dateEnd], [description], [urlImage], [isRemoved]) VALUES (N'MSSPECIAL', N'Special Mission', N'Completed', CAST(N'2018-07-15' AS Date), NULL, N'Special Mission rewards Biometrics, each set having a few that can mainly be found there. The only limit on the amount of Biometrics you can get from Special Mission is the number of entries per day (limited to 20 and can use crystals for additional entries) and the random chance to get a Biometric on each run.', N'src/img/[Mission]MSSPECIAL.png', 0)
SET IDENTITY_INSERT [dbo].[MissionDetail] ON 

INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (48, N'jarvis', N'MS001', 0)
INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (49, N'tonytony', N'MS001', 0)
INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (50, N'ducthotran2010', N'MS001', 0)
INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (51, N'jarvis', N'MS002', 0)
INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (52, N'AntMan11', N'MS002', 0)
INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (53, N'BLACKPANTHER', N'MS002', 0)
INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (54, N'SPIDERMAN', N'MS002', 0)
INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (55, N'SCARLETWITCH', N'MS002', 0)
INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (56, N'HULKHULK', N'MS002', 0)
INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (57, N'AntMan11', N'MSSPECIAL', 0)
INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (58, N'ducthotran2010', N'MS004', 0)
INSERT [dbo].[MissionDetail] ([id], [username], [missionID], [isQuitted]) VALUES (59, N'tonytony', N'MS004', 0)
SET IDENTITY_INSERT [dbo].[MissionDetail] OFF
INSERT [dbo].[User] ([username], [password], [fullname], [role], [abilities], [powers], [height], [weight], [dateJoined], [urlAvatar], [isDeactive]) VALUES (N'AntMan11', N'123456', N'Ant-Man', N'User', N'Marvel''s "Ant-Man" stars Paul Rudd as Scott Lang aka Ant-Man, Evangeline Lilly as Hope Van Dyne, Corey Stoll as Darren Cross aka Yellowjacket, Bobby Cannavale as Paxton, Michael PeÃ Â±a as Luis, Judy Greer as Maggie.', N'Size and Shape Alteration
Superhuman Intelligence
Superhuman Strength
Superhuman Durability
Energy Blasts', N'6''', N'190 lbs.', CAST(N'2018-07-15' AS Date), N'src/img/AntMan11.jpg', 0)
INSERT [dbo].[User] ([username], [password], [fullname], [role], [abilities], [powers], [height], [weight], [dateJoined], [urlAvatar], [isDeactive]) VALUES (N'BLACKPANTHER', N'123456', N'BLACK PANTHER', N'User', N'', N'Heightened Senses
Night Vision
Hand-to-Hand Combat
Superhuman Strength
', N'6''', N'200 lbs.', CAST(N'2018-07-15' AS Date), N'src/img/BLACKPANTHER.jpg', 0)
INSERT [dbo].[User] ([username], [password], [fullname], [role], [abilities], [powers], [height], [weight], [dateJoined], [urlAvatar], [isDeactive]) VALUES (N'ducthotran2010', N'123456', N'Duc Tho Tran', N'User', N'Create JARVIS WEB', N'None', N'Unknown', N'Unknown', CAST(N'2018-07-15' AS Date), N'src/img/ducthotran2010.jpg', 0)
INSERT [dbo].[User] ([username], [password], [fullname], [role], [abilities], [powers], [height], [weight], [dateJoined], [urlAvatar], [isDeactive]) VALUES (N'HULKHULK', N'123456', N' Robert Bruce Banner', N'User', N'Dr. Bruce Banner is a genius in nuclear physics, possessing a mind so brilliant that it cannot be measured on any known intelligence test. When Banner is the Hulk, Banner''s consciousness is buried within the Hulk''s.', N'The Hulk possesses an incredible level of superhuman physical ability. His capacity for physical strength is potentially limitless due to the fact that the Hulk''s strength increases proportionally with his level of great emotion.', N'5'' 9Â½" (Banner); 6''6" (gray Hulk); 7'' â?? 8'' (green/savageHulk); 7''6" (green/Professor Hulk)', N'128 lbs. (Banner); 900 lbs. (gray Hulk); 1,040 â?? 1,400 lbs.(green/savage Hulk); 1,150 lbs. (green/Professor Hulk)', CAST(N'2018-07-15' AS Date), N'src/img/HULKHULK.jpg', 0)
INSERT [dbo].[User] ([username], [password], [fullname], [role], [abilities], [powers], [height], [weight], [dateJoined], [urlAvatar], [isDeactive]) VALUES (N'jarvis', N'jarvis', N'J.A.R.V.I.S', N'Admin', N'', N'', N'', N'', NULL, N'src/img/jarvis.A.R.V.I.S..jpg', 0)
INSERT [dbo].[User] ([username], [password], [fullname], [role], [abilities], [powers], [height], [weight], [dateJoined], [urlAvatar], [isDeactive]) VALUES (N'SCARLETWITCH', N'123456', N'SCARLET WITCH', N'User', N'', N'lluminationMagic (Chaos Magic)Matter TransmutationNexus BeingPowers of Life and DeathProbability AlterationPsychometryPrecognitionMagicMind ControlHealing FactorReality WarpingControl of ElementsPsionicsCommuning with Deceased Spirits', N'5''7''', N'132 lbs', CAST(N'2018-07-15' AS Date), N'src/img/SCARLETWITCH.jpg', 0)
INSERT [dbo].[User] ([username], [password], [fullname], [role], [abilities], [powers], [height], [weight], [dateJoined], [urlAvatar], [isDeactive]) VALUES (N'SPIDERMAN', N'123456', N'Peter Benjamin Parker', N'User', N'Peter is an accomplished scientist, inventor and photographer.', N'Superhuman Strength
Superhuman Speed
Superhuman Reflexes
Superhuman Durability
Camouflage Ability (Near Invisibility)
"Spider-Sense" Alert
Venom Blasts
Wallcrawling
Energy Blasts', N'5''2''', N'125 lbs.', CAST(N'2018-07-15' AS Date), N'src/img/SPIDERMAN.jpg', 0)
INSERT [dbo].[User] ([username], [password], [fullname], [role], [abilities], [powers], [height], [weight], [dateJoined], [urlAvatar], [isDeactive]) VALUES (N'THANOS', N'123456', N'THANOS', N'User', N'', N'', N'', N'', CAST(N'2018-07-15' AS Date), N'src/img/THANOS.jpg', 1)
INSERT [dbo].[User] ([username], [password], [fullname], [role], [abilities], [powers], [height], [weight], [dateJoined], [urlAvatar], [isDeactive]) VALUES (N'THORTHOR', N'123456', N'THOR', N'User', N'', N'', N'', N'', CAST(N'2018-07-15' AS Date), N'src/img/THORTHOR.jpg', 0)
INSERT [dbo].[User] ([username], [password], [fullname], [role], [abilities], [powers], [height], [weight], [dateJoined], [urlAvatar], [isDeactive]) VALUES (N'tonytony', N'123456', N'IRON MAN', N'Admin', N'Genius-level intellect
Proficient scientist and engineer
Powered armor suit:
    - Superhuman strength and durability
    - Supersonic flight
    - Energy repulsor and missile projection
    - Regenerative life ', N'Heightened Senses
Superhuman Strength
Regeneration
Genius Intelligence', N'6''1'', In Armor: 6''6''', N'225 lbs., In Armor: 425 lbs.', CAST(N'2018-07-15' AS Date), N'src/img/tonytony.jpg', 0)
ALTER TABLE [dbo].[Equipment]  WITH CHECK ADD  CONSTRAINT [FK_Equipment_User] FOREIGN KEY([username])
REFERENCES [dbo].[User] ([username])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Equipment] CHECK CONSTRAINT [FK_Equipment_User]
GO
ALTER TABLE [dbo].[MissionDetail]  WITH CHECK ADD  CONSTRAINT [FK_MissionDetail_Mission] FOREIGN KEY([missionID])
REFERENCES [dbo].[Mission] ([id])
GO
ALTER TABLE [dbo].[MissionDetail] CHECK CONSTRAINT [FK_MissionDetail_Mission]
GO
ALTER TABLE [dbo].[MissionDetail]  WITH CHECK ADD  CONSTRAINT [FK_MissionDetail_User] FOREIGN KEY([username])
REFERENCES [dbo].[User] ([username])
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[MissionDetail] CHECK CONSTRAINT [FK_MissionDetail_User]
GO
ALTER TABLE [dbo].[Mission]  WITH CHECK ADD  CONSTRAINT [CK_Mission] CHECK  (([status]='Base on real time' OR [status]='Completed' OR [status]='Cancelled' OR [status]='Failed'))
GO
ALTER TABLE [dbo].[Mission] CHECK CONSTRAINT [CK_Mission]
GO
USE [master]
GO
ALTER DATABASE [avengers] SET  READ_WRITE 
GO
