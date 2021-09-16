# Video Club project file structure
Project is structured by separating packages for bussiness logic (videoClubClasses) and  classes that contain interactions with the user (userInterface).

```
src/main
│   Main   
└─── ui
|    └─── Menu
|    └─── MenuStrings
|    └─── ScannerActions
|    └─── commands
|         └─── Command
|         └─── ...
|
└─── club
|    └──Customer
|    └──Media
|    |  └── Movie
|    |  └── MusicAlbum
|    |  └── Videogame
|    └── Rental
└─── inventory
     └─── Inventory
     └─── MediaInventory
     └─── CustomerInventory
     └─── RentalInventory

```


