public class ThreadExample {
  public static void main(String[] args) {
    // ThreadLoadingBar threadBar = new ThreadLoadingBar();
    // ThreadLoadingBar threadBar2 = new ThreadLoadingBar();
    GeneratePDF gPdf = new GeneratePDF();
    LoadingBar lBar = new LoadingBar(gPdf);
    
    // threadBar.start();
    // threadBar2.start();
    lBar.start();
    gPdf.start();
  }
}

class GeneratePDF extends Thread {
  @Override
  public void run() {
    System.out.println("Iniciar PDF");
    try {
      Thread.sleep(5000);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("PDF gerado");
  }
}

class LoadingBar extends Thread {
  private Thread initiatePDF;

  public LoadingBar(Thread initiatePDF) {
    this.initiatePDF = initiatePDF;
  }

  @Override
  public void run() {
    while (true) {
      try {
        Thread.sleep(500);

        if (!initiatePDF.isAlive()) {
          break;
        }

      } catch (Exception e) {
        e.printStackTrace();
      }

      System.out.println("Loading...");
    }
  }
}

// class ThreadLoadingBar extends Thread {
//   @Override
//   public void run() {
//     super.run();
//     System.out.println("rodei " + this.getName());

//     try {
//       Thread.sleep(5000);
//     } catch (Exception e) {
//       e.printStackTrace();
//     }
//   }
// }