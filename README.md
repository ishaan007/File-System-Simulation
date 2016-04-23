FAT File System Simulation
==========================

### Introduction

This application is a simulation of the File Allocation Table (FAT) file
system, programmed in Java. There are a total of 5 files in the
application. Each file performs different functions of a file system, on
a single common file, which acts as a virtual hard disk.

### FAT File System

The FAT file system, irrespective of the particular specification of it
such as FAT32 or FAT16, divides the the available main memory into 3
areas, namely,

-   Boot Sector
-   Meta Data Area
-   File Data Area

The first is the Boot sector; this section contains all the
intialization functions and variables where the entire sturcture of the
file system is defined, such as the number of clusters and the size of
each cluster. The next section is the meta data section, where the meta
data of all the files that are created is stored. This includes the size
of the file, extension and date of creation, among others. This unit
also stores the actual file allocation table, used to look up the
location of a file in the third unit, which contains the actual data of
the files stored. This data unit is divided into clusters of certain
sizes. These clusters are a logical construct that are used to store
data.

### Simulating the FAT File System On a File

For the simulation, we first need some empty memory to work on. We can
create a text file of a specific size. We fill the file with a special
character to ensure that the file of desired size has been created and
is not empty. We now use this file as a virtual hard disk to carry out
all the operations of a file system. These functions include

-   Create File
-   Delete File
-   Read File
-   Edit File
-   Move File
-   Rename File

### Implementation

We first create a file that is 2 MBs in size. To ensure we do not create
an empty file, we fill this file with the ‘\#’ character enough times,
so that the file size is 2 MBs. We then divide this 2 MB file into the 3
units described above. We allocate 8192 bytes to the boot or
initialization unit. When you run the initialization file, it overwrites
the \# characters with the structure of the file system, i.e, how many
bytes have been allocated to the different units, how many clusters
there are and the size of each cluster. We have created 4 clusters and
we have imposed a restriction that no more than 4 files can be created
in this file system.

We make use of Java’s file handling operations to carry out the specifix
tasks. Specifically, we make use the RandomAccessFile class. Using this
class allows us to move freely in the file and make changes in a
specific part of the file while retaining the contents of any other
part.

To implement the FAT file lookup procedure, we use the
RandomAccessFile’s seek method. The seek method gives us a pointer to
that specific byte and we can jump to it. For example, if we create an
object this class named file, we can jump to the 200th byte as so

    file.seek(200)

This allows us to make distinctions between the different areas in our
virtual hard disk. When we ru nthe application, it reads the number of
files that have been created already from the boot sector or
initialisation area. If there are 4 files created and the user wants to
create another file, it throws an exception. If there are some number of
files created that are valid and we want to run any operations on that
file, we jump to the starting pointer of that file and make any changes
we want to.

##### Files

-   MemoryCreateAndInitialize file creates the 2 MB file filled with
    \#'s
-   MemoryIntialize file writes the intialization details in the first
    8192 bytes of the file
-   FileAccessAndUse file contains all the methods for creating,
    deleting, updating, renaming, reading and writing data onto the
    file.
-   FileAccessAndUseInterface file is a continously running file that
    prompts the user to provide input to perform any of the operations
    given above.


