import java.awt.*
import java.awt.event.*
import javax.swing.*

class SnakeGame : JFrame() {
    private val canvas = Canvas()
    private var running = false
    private lateinit var timer: Timer
    private lateinit var snake: Snake
    private lateinit var food: Food
    private var score = 0

    init {
        title = "贪吃蛇"
        setSize(400, 400)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        layout = BorderLayout()

        // 添加计分板
        val scoreBoard = JLabel("得分: 0")
        scoreBoard.font = Font("Arial", Font.BOLD, 20)
        add(scoreBoard, BorderLayout.NORTH)

        canvas.setSize(400, 300)
        add(canvas, BorderLayout.CENTER)

        // 添加控制按钮
        val controlPanel = JPanel()
        val startButton = JButton("开始")
        val pauseButton = JButton("暂停")
        val resetButton = JButton("重置")

        startButton.addActionListener {
            running = true
            if (!::timer.isInitialized) {
                timer = Timer(100, object : ActionListener {
                    override fun actionPerformed(e: ActionEvent?) {
                        update()
                    }
                })
                timer.start()
            } else {
                timer.restart()
            }
        }

        pauseButton.addActionListener {
            running = false
            timer.stop()
        }

        resetButton.addActionListener {
            running = false
            score = 0
            scoreBoard.text = "得分: $score"
            canvas.repaint()
            initGame()
        }

        controlPanel.add(startButton)
        controlPanel.add(pauseButton)
        controlPanel.add(resetButton)
        add(controlPanel, BorderLayout.SOUTH)

        // 初始化游戏
        initGame()

        // 处理键盘输入
        canvas.requestFocus()
        canvas.addMouseListener(object : MouseAdapter() {})
        canvas.addKeyListener(object : KeyListener {
            override fun keyTyped(e: KeyEvent?) {}

            override fun keyPressed(e: KeyEvent) {
                when (e.keyChar) {
                    'w' -> if (snake.direction != Direction.DOWN) snake.direction = Direction.UP
                    's' -> if (snake.direction != Direction.UP) snake.direction = Direction.DOWN
                    'a' -> if (snake.direction != Direction.RIGHT) snake.direction = Direction.LEFT
                    'd' -> if (snake.direction != Direction.LEFT) snake.direction = Direction.RIGHT
                }
            }

            override fun keyReleased(e: KeyEvent?) {}
        })
    }

    private fun initGame() {
        snake = Snake()
        food = Food()
        canvas.repaint()
    }

    private fun update() {
        if (!running) return

        try {
            snake.move()
            checkCollision()
            checkFood()
            canvas.repaint()
        } catch (e: Exception) {
            running = false
            score = 0
            JOptionPane.showMessageDialog(this, "Game Over! 按回车键重新开始", "游戏结束", JOptionPane.INFORMATION_MESSAGE)
            canvas.requestFocusInWindow()
        }
    }

    private fun checkCollision() {
        val head = snake.body[0]
        if (head.x < 0 || head.x >= 40 || head.y < 0 || head.y >= 30) throw Exception()

        for (i in 1 until snake.body.size) {
            if (head.x == snake.body[i].x && head.y == snake.body[i].y) throw Exception()
        }
    }

    private fun checkFood(): Boolean {
        val head = snake.body[0]
        return if (head.x == food.x && head.y == food.y) {
            score += 10
            food.generateNewPosition(snake)
            snake.grow()
            true
        } else {
            false
        }

    }

    inner class Snake {
        var direction: Direction = Direction.RIGHT
        val body = mutableListOf<Point>()

        init {
            body.add(Point(20, 15))
            body.add(Point(19, 15))
            body.add(Point(18, 15))
        }

        fun move() {
            val head = Point(body[0].x + when (direction) {
                Direction.UP -> -1
                Direction.DOWN -> 1
                Direction.LEFT -> 0
                Direction.RIGHT -> 0
            }, body[0].y + when (direction) {
                Direction.UP -> 0
                Direction.DOWN -> 0
                Direction.LEFT -> -1
                Direction.RIGHT -> 1
            })

            body.add(0, head)
            if (!checkFood()) body.removeAt(body.size - 1)
        }

        fun grow() {
            val tail = Point(body.last().x + when (direction) {
                Direction.UP -> 1
                Direction.DOWN -> -1
                Direction.LEFT -> 0
                Direction.RIGHT -> 0
            }, body.last().y + when (direction) {
                Direction.UP -> 0
                Direction.DOWN -> 0
                Direction.LEFT -> 1
                Direction.RIGHT -> -1
            })

            body.add(tail)
        }
    }

    inner class Food {
        var x: Int = 20
        var y: Int = 15

        fun generateNewPosition(snake: Snake) {
            do {
                x = (Math.random() * 40).toInt()
                y = (Math.random() * 30).toInt()
            } while (snake.body.any { it.x == x && it.y == y })
        }
    }

    enum class Direction { UP, DOWN, LEFT, RIGHT }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            SwingUtilities.invokeLater {
                val frame = SnakeGame()
                frame.isVisible = true
            }
        }
    }

    inner class Canvas : JPanel() {
        override fun paintComponent(g: Graphics?) {
            super.paintComponent(g)
            g?.let {
                it.color = Color.BLACK
                it.fillRect(0, 0, width, height)

                it.color = Color.GREEN
                food.generateNewPosition(snake)
                it.fillRect(food.x * 10, food.y * 10, 10, 10)

                for (i in 0 until snake.body.size) {
                    it.color = if (i == 0) Color.YELLOW else Color.WHITE
                    it.fillRect(snake.body[i].x * 10, snake.body[i].y * 10, 10, 10)
                }

                if (!running) {
                    it.color = Color.RED
                    it.font = Font("Arial", Font.BOLD, 30)
                    it.drawString("Game Over!", 150, 150)
                    it.font = Font("Arial", Font.PLAIN, 20)
                    it.drawString("按回车键重新开始", 140, 170)
                }
            }
        }
    }
}
