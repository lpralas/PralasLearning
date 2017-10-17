package hr.java.example;

import java.util.*;

import java.io.*;



public class FileUpdate {
	private static final String CODE_CITY_FOLDER = "C:\\Users\\pralas\\Desktop\\Zadatak\\1\\Folder A\\code_city.txt";
	private static final String COPY_CODE_CITY_FOLDER = "C:\\Users\\pralas\\Desktop\\Zadatak\\1\\Folder B\\copy_code_city.txt";
	private static final String CHANGED_CODE_CITY = "C:\\Users\\pralas\\Desktop\\Zadatak\\1\\Folder C\\changed_code_city12102017.txt";
	private static final String NEW_FILE = "C:\\Users\\pralas\\Desktop\\Zadatak\\1\\Folder C";
	static void modifyFile(String filePath, String oldString, String newString) {
        File fileToBeModified = new File(filePath);
        String oldContent = "";

		BufferedReader reader = null;

		FileWriter writer = null;

		try {

			reader = new BufferedReader(new FileReader(fileToBeModified));

			// Reading all the lines of input text file into oldContent

			String line = reader.readLine();

			while (line != null) 

			{

				oldContent = oldContent + line + System.lineSeparator();

				line = reader.readLine();

			}

			// Replacing oldString with newString in the oldContent

			String newContent = oldContent.replaceAll(oldString, newString);

			// Rewriting the input text file with newContent

			writer = new FileWriter(fileToBeModified);

			writer.write(newContent);

		}

		catch (IOException e)

		{
			//S.P.--> At this moment you can use this. But if you want know more google log4j.
			//If there is some error it should be written in file on filesystem.
			e.printStackTrace();

		}

		finally

		{

			try

			{

				// Closing the resources

				reader.close();

				writer.close();

			}

			catch (IOException e)

			{
				
				e.printStackTrace();

			}

		}

	}

	public static void main(String[] args) throws IOException {

		
		Scanner dataFromCodeCityFolder = new Scanner(
				new FileReader(CODE_CITY_FOLDER));

		Scanner dataFromCopyCityFolder = new Scanner(
				new FileReader(COPY_CODE_CITY_FOLDER));
		//S.P. Use variable names that have sense. p is only letter
		File folderC = new File(NEW_FILE);

		folderC.mkdirs();

		File changedCodeCity = new File(CHANGED_CODE_CITY);
				
		changedCodeCity.createNewFile();

		try (BufferedWriter br = new BufferedWriter(new FileWriter(changedCodeCity))) {

			while ((dataFromCodeCityFolder.hasNextLine()) || (dataFromCopyCityFolder.hasNextLine())) {

				String[] columnsFromTextFileA = dataFromCodeCityFolder.nextLine().split(" ");

				String[] columnsFromTextFileB = dataFromCopyCityFolder.nextLine().split(" ");

				if (columnsFromTextFileA[0].equals(columnsFromTextFileB[0])) {

					br.write(columnsFromTextFileA[0]);

					br.write("\t\t" + columnsFromTextFileB[1]);

					br.newLine();

				}

				else {

					br.write(columnsFromTextFileA[0]);

					br.write("\t" + columnsFromTextFileB[0]);

					br.write("\t" + columnsFromTextFileB[1]);

					br.newLine();

					modifyFile(CODE_CITY_FOLDER,
							columnsFromTextFileA[0], columnsFromTextFileB[0]);

				}

			}

		}

		catch (IOException e) {
		}

	}

}
