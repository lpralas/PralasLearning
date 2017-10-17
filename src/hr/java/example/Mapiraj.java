package hr.java.example;

import java.util.*;

import java.io.*;

class Mapiraj {
	static void modifyFile(String filePath, String oldString, String newString)

	{

		File fileToBeModified = new File(filePath);

		String oldContent = "";

		BufferedReader reader = null;

		FileWriter writer = null;

		try

		{

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

		Scanner scanner = new Scanner(
				new FileReader(
						"C:\\Users\\pralas\\Desktop\\Zadatak\\1\\Folder A\\code_city.txt"));

		Scanner scanner1 = new Scanner(
				new FileReader(
						"C:\\Users\\pralas\\Desktop\\Zadatak\\1\\Folder B\\copy_code_city.txt"));

		File p = new File("C:\\Users\\pralas\\Desktop\\Zadatak\\1\\Folder C");

		p.mkdirs();

		File f = new File(
				"C:\\Users\\pralas\\Desktop\\Zadatak\\1\\Folder C\\changed_code_city12102017.txt");

		f.createNewFile();

		try (BufferedWriter br = new BufferedWriter(new FileWriter(f))) {

			while ((scanner.hasNextLine()) || (scanner1.hasNextLine())) {

				String[] columns = scanner.nextLine().split(" ");

				String[] columns1 = scanner1.nextLine().split(" ");

				if (columns[0].equals(columns1[0])) {

					br.write(columns[0]);

					br.write("\t\t" + columns[1]);

					br.newLine();

				}

				else {

					br.write(columns[0]);

					br.write("\t" + columns1[0]);

					br.write("\t" + columns1[1]);

					br.newLine();

					modifyFile(
							"C:\\Users\\pralas\\Desktop\\Zadatak\\1\\Folder A\\code_city.txt",
							columns[0], columns1[0]);

				}

			}

		}

		catch (IOException e) {
		}

	}

}
