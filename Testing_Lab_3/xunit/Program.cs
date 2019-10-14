using NUnit.Framework;

namespace xunit
{
    class Program
    {
        static void Main(string[] args)
        {

        }
    }

    [TestFixture]
    public class MathTest
    {
        [Test]
        public void FirstTest()
        {
            Assert.IsTrue(Triangler.TriangleExist(1, 1, 1));
        }

        [TestCase(200, 1, 300)]
        public void SecondTest(float a, float b, float c)
        {
            Assert.IsTrue(!Triangler.TriangleExist(a, b, c));
        }

        [TestCase(30, 3, 40, ExpectedResult = false)]
        [TestCase(20, 400, 6, ExpectedResult = false)]
        [TestCase(12, 23, 34, ExpectedResult = false)]
        [TestCase(12, 3, 36, ExpectedResult = false)]
        [TestCase(120, 24, 72, ExpectedResult = false)]
        [TestCase(111, 213, 322, ExpectedResult = true)]
        [TestCase(133, 2275, 32, ExpectedResult = false)]
        [TestCase(50, 100, 150, ExpectedResult = true, Description = "Sides: 50, 100, 150")]

        public bool TestSequence(float a, float b, float c) => TriangleTester.TriangleExist(a, b, c);
        
    }

    public static class TriangleTester
    {
        public static bool TriangleExist(float a, float b, float c)
        {
            return (a + b > c) && (b + c > a) && (a + c > b);
        }
    }
}
