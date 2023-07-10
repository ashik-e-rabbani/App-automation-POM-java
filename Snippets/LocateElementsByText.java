public boolean checkIfTextExists() throws InterruptedException {
        String searchText = "YOUR TEXT";

        // Get all text elements on the screen
        List<MobileElement> textElements = appLauncher.getAppiumDriver().findElements(By.className("android.widget.TextView"));
        // Check if the text is present in any of the elements
        boolean textFound = false;
        for (MobileElement element : textElements) {
            if (element.getText().contains(searchText)) {
                textFound = true;
                break;
            }
        }

        return textFound;
    }