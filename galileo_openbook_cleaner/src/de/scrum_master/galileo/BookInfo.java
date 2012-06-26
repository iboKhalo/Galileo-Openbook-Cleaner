package de.scrum_master.galileo;

import java.math.BigInteger;

enum BookInfo
{
	ACTIONSCRIPT_1_UND_2  ("design_actionscript",                            "f0fce9b57be89d1263ab5aad218f08d9", "9783898422215"),
	ACTIONSCRIPT_EINSTIEG ("design_actionscript_einstieg",                   "d873a2bea68a0184137f8e95370d2dac", "9783898427746"),
	APPS_IPHONE           ("computing_apps_entwickeln_fuer_iphone_und_ipad", "4ec481acdd85478ea58dbc246811732f", "9783836214636"),
	C_VON_A_BIS_Z         ("computing_c_von_a_bis_z",                        "082b31208caf318669f6577431afaba5", "9783836214117"),
	DREAMWEAVER_8         ("design_dreamweaver8",                            "77b4ccc2e734aa69b4f5e0326b176082", "9783898427395"),
	EXCEL_2007            ("computing_excel_2007",                           "8a3c67bcce5014de42aed6a887f18b5d", "9783898428644"),
	HDR_FOTOGRAFIE        ("design_hdr_fotografie",                          "05f1f03fddeb2d46ddb6f3dcf6417245", "9783836211031"),
	IT_HANDBUCH           ("computing_it_handbuch",                          "69095040b73028fe6e5b5cf2e1ac3305", "9783836217446"),
	JAVA_7                ("computing_java7",                                "a6c42f70b09fed65c3397e817f3b246d", "9783836215077"),
	JAVA_INSEL            ("computing_javainsel",                            "3f7fa5da11cbec50e9a2f4c7952f0499", "9783836218023"),
	JAVASCRIPT_AJAX       ("computing_javascript_ajax",                      "1fdb716ed9120e26dd9f501356e712a9", "9783898428590"),
	JOOMLA_1_5            ("computing_joomla15",                             "81b816d22da3da064d3b23b97266cf2f", "9783898428811"),
	LINUX                 ("computing_linux",                                "d1109e488213c93e5468b444cde7698d", "9783836218221"),
	LINUX_UNIX_PROG       ("computing_linux_unix_programmierung",            "c4d37159abde2c2f9757d6c37d45b0d7", "9783836213660"),
	MICROSOFT_NETZWERK    ("computing_microsoft_netzwerk",                   "814a46492426ca26ad82cc61b80f12c9", "9783898428477"),
	OOP                   ("computing_oop",                                  "0151c9177aba7007ac74b63ded2c7c05", "9783836214018"),
	PHOTOSHOP_CS2         ("design_photoshop_cs2",                           "19dfce0450057f826b2470b219d44496", "9783898427005"),
	PHOTOSHOP_CS4         ("design_photoshop_cs4",                           "d1577a92737b79d334c078a588019bf8", "9783836212373"),
	PHP_PEAR              ("computing_php_pear",                             "10e51e01cbb003c5931d881c2c367740", "9783898425803"),
	PYTHON                ("computing_python",                               "802f910e3847565f3d1f981a23ca937f", "9783836211109"),
	RUBY_ON_RAILS_2       ("computing_ruby_on_rails",                        "53684c91088ba485f0d716673f66237f", "9783898427791"),
	SHELL_PROG            ("computing_shell_programmierung",                 "fe8361f8b858f671ae2d57671ad15042", "9783898426831"),
	UBUNTU_10_04          ("computing_ubuntu_1004",                          "4f93012ba0196f7bc6db17d67d657c79", "9783836216548"),
	UBUNTU_11_04          ("computing_ubuntu",                               "345a82a633e52bd0c39f9e15ba5826b3", "9783836217651"),
	UNIX_GURU             ("computing_unix_guru",                            "eeca900fe5144ea39e63620a5e45032a", "9783898422406"),
	VB_2008               ("computing_visualbasic_2008",                     "766474d8b583a88d346801a77748c654", "9783836211710"),
	VB_2008_EINSTIEG      ("computing_einstieg_vb_2008",                     "319a48ff5ed8da00fbdbafb4e904a263", "9783836211925"),
	VB_2010_EINSTIEG      ("computing_einstieg_vb_2010",                     "825bc75e2779468f49c27e01c1425181", "9783836215411"),
	VCSHARP_2008          ("computing_visual_csharp",                        "58bfb6559241a96e6155c7becb00902b", "9783836211727"),
	VCSHARP_2010          ("computing_visual_csharp_2010",                   "b08df7f094e2155273d4b16dfc75b0d0", "9783836215527"),
	VMWARE                ("computing_vmware",                               "c858eff1750f2e3840894a8d1e306a0a", "9783898427012"),
	WINDOWS_SERVER_2008   ("computing_windows_server_2008",                  "3df493a8dbf04b9fce3c24ba8ed5e995", "9783836215282"),
	;

	final String unpackDirectory;
	final String downloadArchive;
	final BigInteger archiveMD5;
	final String coverImage;

	private final static String BOOK_URL       = "http://download2.galileo-press.de/openbook/"; 
	private final static String COVER_URL      = "http://cover.galileo-press.de/";
	private final static String ARCHIVE_PREFIX = "galileo"; 

	private BookInfo(String downloadArchive, String archiveMD5, String coverImage)
	{
		this.unpackDirectory = name().toLowerCase();
		this.downloadArchive = BOOK_URL + ARCHIVE_PREFIX + downloadArchive + ".zip";
		this.archiveMD5 = new BigInteger(archiveMD5, 16);;
		this.coverImage = COVER_URL + coverImage + ".jpg";
	}

	public static void main(String[] args)
	{
		// Iterate over enum and access members
		for (BookInfo bookInfo : BookInfo.values()) {
			System.out.println(bookInfo.name());  // or just 'bookInfo'
			System.out.println("  unpackDirectory = " + bookInfo.unpackDirectory);
			System.out.println("  downloadArchive = " + bookInfo.downloadArchive);
			System.out.println("  archiveMD5      = " + bookInfo.archiveMD5.toString(16));
			System.out.println("  coverImage      = " + bookInfo.coverImage);
		}
		System.out.println();

		// Convert string into enum identifier
		System.out.println(BookInfo.valueOf("LINUX"));

		// Handle illegal identifier + get its name from exception message 
		try {
			System.out.println(BookInfo.valueOf("FOOBAR_BOOK"));
		}
		catch (IllegalArgumentException e) {
			System.err.println(
				"Error: book info element " + 
				e.getMessage().replaceFirst(".*[.]", "") +
				" not found"
			);
		}
	}
}