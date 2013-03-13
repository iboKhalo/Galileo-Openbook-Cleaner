HTML cleaner for Galileo openbooks
==================================

This is a tool for cleaning up [Galileo Computing openbooks](http://www.galileocomputing.de/openbook)
before converting them to EPUB or PDF format.

__Current state of development:__ v1.1.0 is feature complete, i.e. it can download, MD5-verify, unpack
and convert all 37 openbooks available at release time.

__Download:__ A precompiled, executable JAR file is available
[here](http://scrum-master.de/download/GalileoOpenbookCleaner/galileo_openbook_cleaner-1.1.0.jar). 

__Usage:__

    $ java -jar galileo_openbook_cleaner-1.1.0.jar --help
    
    OpenbookCleaner usage: java ... [options] <book_id>*

    Option                                  Description
    ------                                  -----------
    -?, --help                              Display this help text
    -c, --check-avail                       Check Galileo homepage for available
                                              books, compare with known ones
    -d, --download-dir <File>               Download directory for openbooks; must
                                              exist (default: .)
    -l, --log-level <Integer>               Log level (0=normal, 1=verbose,
                                              2=debug, 3=trace) (default: 0)
    -m, --check-md5                         Download all known books without
                                              storing them, verifying their MD5
                                              checksums (slow! >1 Gb download)
    -t, --threading <Integer>               Threading mode (0=single, 1=multi);
                                              single is slower, but better for
                                              diagnostics) (default: 1)
    -w, --write-config                      Write editable book list to config.xml

    book_id1 book_id2 ...                   Books to be downloaded & converted

    Legal book IDs:
      all (magic value: all books), actionscript_1_und_2, actionscript_einstieg,
      apps_iphone_ios5, apps_iphone_ios6, asp_net, c_von_a_bis_z, dreamweaver_8,
      excel_2007, hdr_fotografie, it_handbuch, javascript_ajax, java_7, java_insel,
      joomla_1_5, linux, linux_unix_prog, microsoft_netzwerk, oop, photoshop_cs2,
      photoshop_cs4, php_pear, python, ruby_on_rails_2, shell_prog, ubuntu_10_04,
      ubuntu_11_04, ubuntu_12_04, unix_guru, vb_2008, vb_2008_einstieg,
      vb_2010_einstieg, vb_2012_einstieg, vcsharp_2008, vcsharp_2010, vcsharp_2012,
      vmware, windows_server_2008

__Dependencies:__ Openbook cleaner was developed in Java 6. It also uses a few open source libraries (see
[readme.txt](https://github.com/kriegaex/Galileo-Openbook-Cleaner/tree/v1.0_stable/galileo_openbook_cleaner/lib)
for download links and installation instructions):

  * __jsoup 1.7.2__ for parsing the "dirty" openbook HTML, selecting DOM elements and editing them, removing
    navigation elements, ads and other types of clutter, and finally write a clean, pretty-printed HTML
    document back to disk
  * __JOpt Simple 4.3__ for parsing command-line parameters and showing a help page (usage info)
  * __Apache Commons Compress 1.4.1__ for unzipping downloaded openbook archives. *Note: When Java 7 is
    available on MacOS, this library might be removed again and we can revert to using the built-in Java
    classes.*
  * __XStream 1.4.4__ parsing the *config.xml* file containing openbook meta data
  * __AspectJ 1.7.0__ for cross-cutting concerns like logging, timing, tracing which are not part of the
    main application logic. This helps to keep the core code clean and free from scattered code addressing
    secondary concerns. The AspectJ runtime is part of the pre-packaged JAR available for download, so you
    only need to install AspectJ if you want to build the application by yourself.

Because later I might want to use this *Git* repository as a refactoring showcase for my developer workshops,
I am going to do any refactoring step by step, documenting progress in small, fine-granular *Git* changesets,
so later on I can review the evolutionary progress with others.

As you can see, I am mostly doing this little project for myself, but I like to share the results and
receive some user feedback. I hope the openbook cleaner is useful to you. Enjoy! :-)

Alexander Kriegisch
